package aop.controller;



import aop.model.Sample;
import aop.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gkatzioura on 5/28/16.
 */
@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping("/sample")
    public Sample sample(String sampleName) {
        return sampleService.createSample(sampleName);
    }

}
