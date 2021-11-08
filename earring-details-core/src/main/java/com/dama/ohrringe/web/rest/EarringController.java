package com.dama.ohrringe.web.rest;

import com.dama.ohrringe.EarringApi;
import com.dama.ohrringe.domain.Earring;
import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.dto.EarringDetailRestDto;
import com.dama.ohrringe.dto.EarringRestDto;
import com.dama.ohrringe.service.EarringService;
import com.dama.ohrringe.service.PriceConfigService;
import com.dama.ohrringe.service.mapper.EarringMapper;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class EarringController implements EarringApi {

  EarringService earringService;
  PriceConfigService priceConfigService;
  EarringMapper mapper = Mappers.getMapper(EarringMapper.class);

  @Autowired
  public EarringController(EarringService earringService, PriceConfigService priceConfigService) {
    this.earringService = earringService;
    this.priceConfigService = priceConfigService;
  }


  @Override
  public ResponseEntity<List<EarringRestDto>> getAllEarrings() {
    log.info("Received request to get earrings");
    List<Earring> allEarrings = earringService.findAllEarrings();
    List<EarringRestDto> earringsRestDto = mapper.domainToRestDto(allEarrings);
    earringsRestDto.stream().forEach(earring -> setPrice(earring));
    log.info("Received request to get earrings is processed successfully");
    return ResponseEntity.ok(earringsRestDto);
  }

  @Override
  public ResponseEntity<EarringRestDto> getEarring(String id) {
    log.info("Received request to get earring by id {}", id);
    Earring earring = earringService.findEarringById(id).get();
    EarringRestDto earringRestDto = mapper.domainToRestDto(earring);
    setPrice(earringRestDto);
    log.info("Received request to get earring by id {} is processed successfully", id);
    return ResponseEntity.ok(earringRestDto);
  }

  @Override
  public ResponseEntity<EarringRestDto> postEarring(EarringRestDto earringRestDto) {
    log.info("Received request to add earring detail {}", earringRestDto);
    Earring earring = earringService.createEarring(mapper.restDtoToDomain(earringRestDto));
    Earring newEarring = earringService.createEarring(earring);
    EarringRestDto restDto = mapper.domainToRestDto(newEarring);
    setPrice(restDto);
    log.info("Received request to add earring detail {} is processed successfully", restDto);
    return ResponseEntity.ok(restDto);
  }

  @Override
  public ResponseEntity<EarringRestDto> putEarring(EarringRestDto earringRestDto) {
    log.info("Received request to update earring {}", earringRestDto);
    Earring earring = earringService.createEarring(mapper.restDtoToDomain(earringRestDto));
    Earring newEarring = earringService.createEarring(earring);
    EarringRestDto restDto = mapper.domainToRestDto(newEarring);
    setPrice(restDto);
    log.info("Received request to update earring {} is processed successfully", restDto);
    return ResponseEntity.ok(restDto);
  }

  @Override
  public ResponseEntity<Void> deleteById(String id) {
    log.info("Received request to delete earring by id {}", id);
    earringService.deleteById(id);
    log.info("Received request to delete earring by id {} is processed successfully", id);
    return ResponseEntity.ok().build();
  }

  private void setPrice(EarringRestDto earringRestDto) {
    List<EarringDetailRestDto> earringDetails = earringRestDto.getEarringDetails();
    double priceDetails = getPriceEarring(earringDetails);
    earringRestDto.setPriceDetails(priceDetails);
    double premiumRate = priceConfigService.getPremiumRate();
    double premium = priceDetails * premiumRate / 100;
    earringRestDto.setPremium(premium);
    earringRestDto.setTotalPrice(priceDetails + premium);
  }


  private double getPriceEarring(List<EarringDetailRestDto> earringDetails) {
    double price = 0;
    for (EarringDetailRestDto earringDetail : earringDetails) {
      price += earringDetail.getPrice();
    }
    return price;
  }

}
