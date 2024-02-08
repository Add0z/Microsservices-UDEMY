package br.udemy.andre.chatgpt.Service;


import br.udemy.andre.chatgpt.Vo.Request.GPTrequest;
import br.udemy.andre.chatgpt.response.GPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class GPTservice {

    private Logger logger = Logger.getLogger(GPTservice.class.getName());


    @Value("${openai.model}")
    private String model;


    @Value("${openai.api.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public String chat(String prompt) {
        logger.info("Initializing chat");
        GPTrequest request = new GPTrequest(model, prompt);

        logger.info("Processing OpenAI");
        GPTResponse response = restTemplate.postForObject(url, request, GPTResponse.class);


        logger.info("Chat finished");


        return response.getChoices().get(0).getMessage().getContent();
    }


}
