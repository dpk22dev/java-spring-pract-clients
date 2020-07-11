package org.pract.demo.two.service;

import org.springframework.stereotype.Service;

@Service
public class SampleJobService {
    public void executeSampleJob() {
        try {
            System.out.println("inside sample job");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        } finally {
        }
    }
}
