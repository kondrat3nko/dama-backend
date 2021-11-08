package com.dama.ohrringe;

import com.dama.ohrringe.domain.Earring;
import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.domain.PriceConfig;
import com.dama.ohrringe.dto.EarringRestDto;
import com.dama.ohrringe.service.EarringDetailService;
import com.dama.ohrringe.service.EarringService;
import com.dama.ohrringe.service.PriceConfigService;
import com.dama.ohrringe.web.rest.EarringController;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
class EarringDetailsCoreApplicationTests {

  @Autowired
  EarringDetailService earringDetailService;
  @Autowired
  EarringService earringService;
  @Autowired
  PriceConfigService priceConfigService;
  @Autowired
  EarringController earringController;


  @Test
  void contextLoads() {

    ResponseEntity<List<EarringRestDto>> allEarrings = earringController.getAllEarrings();
    allEarrings.getBody().size();
    for (EarringRestDto earringRestDto : allEarrings.getBody()){
      System.out.println(earringRestDto.getTotalPrice());
    }

  }

}
