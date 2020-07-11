package org.pract.demo.two.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SampleJobService {
    public void executeSampleJob() {
        try {
//            System.out.println("inside sample job");
            log.info("logging through sample job");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        } finally {
        }
    }
}
