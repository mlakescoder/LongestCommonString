package com.sample.controllers;

import com.sample.api.InputValidation;
import com.sample.api.LongestCommonString;
import com.sample.api.dto.ResultDTO;
import com.sample.api.dto.SampleSetDTO;
import com.sample.api.dto.Value;
import com.sample.controllers.exceptions.BadInputFormatException;
import com.sample.controllers.exceptions.InputEmptyException;
import com.sample.controllers.exceptions.NotASetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class LongestCommonStringController {

    @Autowired
    private LongestCommonString stringService;

    @Autowired
    private InputValidation inputValidation;

    @RequestMapping(value="lcs", method = RequestMethod.POST )
    public ResponseEntity<ResultDTO> processLongestCommonString(@RequestBody(required = false ) SampleSetDTO sampleSetDTO)
                                        throws NotASetException, BadInputFormatException, InputEmptyException
    {
        if ( sampleSetDTO == null ) {
            throw new BadInputFormatException("No data was give. Get sample at ap1/v1/sampleInput");
        }

        if ( sampleSetDTO.getValues().size() == 0 )
            throw new BadInputFormatException("No data was give. Get sample at ap1/v1/sampleInput");

        List<String> inputStrings = sampleSetDTO.getValues().stream().map(v -> { return v.getValue(); }).collect(Collectors.toList());

        inputValidation.validate(inputStrings);

        List<String> processedStrings = stringService.process(inputStrings);

        ResultDTO result = ResultDTO.newBuilder()
                                        .withLcs(stringService.process(inputStrings))
                                        .build();

        return HttpResponse.ok(result);
    }

    @RequestMapping(value="lcs/sampleInput", method = RequestMethod.GET )
    public ResponseEntity<SampleSetDTO> getSampleInput()
            throws NotASetException, BadInputFormatException, InputEmptyException
    {
        List<Value> sampleStrings = new ArrayList<>();
        sampleStrings.add(new Value("dog"));
        sampleStrings.add(new Value("cat"));
        sampleStrings.add(new Value("Mouse"));

        SampleSetDTO result = SampleSetDTO.newBuilder()
                                                .withValues(sampleStrings)
                                                .build();

        return HttpResponse.ok(result);
    }

    @RequestMapping(value="lcs/sampleOutput", method = RequestMethod.GET )
    public ResponseEntity<ResultDTO> getSampleResult()
            throws NotASetException, BadInputFormatException, InputEmptyException
    {
        List<String> sampleStrings = new ArrayList<>();
        sampleStrings.add("dog");
        sampleStrings.add("cat");

        ResultDTO result = ResultDTO.newBuilder()
                .withLcs(sampleStrings)
                .build();

        return HttpResponse.ok(result);
    }


}
