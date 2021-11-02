package com.dama.ohrringe;

import com.dama.ohrringe.domain.Earring;
import com.dama.ohrringe.domain.EarringDetail;
import com.dama.ohrringe.domain.PriceConfig;
import com.dama.ohrringe.service.EarringDetailService;
import com.dama.ohrringe.service.EarringService;
import com.dama.ohrringe.service.PriceConfigService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class EarringDetailsCoreApplicationTests {

  @Autowired
  EarringDetailService earringDetailService;
  @Autowired
  EarringService earringService;
  @Autowired
  PriceConfigService priceConfigService;


  @Test
  void contextLoads() {
//    String newName = "ChangedName";
//    List<EarringDetail> allEarringDetails = earringDetailService.findAllEarringDetails();
//    Earring earring = new Earring();
//    earring.setName("Testing");
//    earring.setEarringDetails(allEarringDetails);
//
//    earringService.createEarring(earring);
//    List<Earring> allEarrings = earringService.findAllEarrings();
//    EarringDetail earringDetail = earring.getEarringDetails().get(0);
//    earringDetail.setName(newName);
//    earringDetailService.createEarringDetail(earringDetail);
//
//    String name = earringService.findAllEarrings()
//                                .get(0)
//                                .getEarringDetails()
//                                .get(0)
//                                .getName();
//    Assert.isTrue(newName.equals(name));

    PriceConfig priceConfig = priceConfigService.findPriceConfig();
    Assert.notNull(priceConfig);

  }

}
