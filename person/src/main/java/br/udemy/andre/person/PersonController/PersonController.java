package br.udemy.andre.person.PersonController;

import br.udemy.andre.person.PersonVO.PersonVO;
import br.udemy.andre.person.PersonVO2.PersonVO2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.udemy.andre.person.Services.PersonService;

import java.util.List;


@RequestMapping(value = "/api/person/v1")
@RestController
@Tag(name = "people", description = "Endpoint for managing people")
public class PersonController {

    @Autowired
   private PersonService PersonService;

    @GetMapping(value = "/{id}",
                    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds a person", description = "Finds a person by id",
            tags = {"people"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = PersonVO.class))),
                    @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
            })
    public PersonVO findById(
            @PathVariable("id") Long id) {
                return PersonService.findById(id);
            }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds all people",
            description = "Finds all people",
            tags = {"people"},
            responses = {
                @ApiResponse(responseCode = "200", description = "Success", content = {
                        @Content(mediaType = "application/json",
                               array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))
                }),
                @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
                @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
            })
    public List<PersonVO> findAllPerson(){
            return PersonService.findAllPersons();
        }

    @PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                                        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Post a person", description = "Post a person",
            tags = {"people"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = PersonVO.class))),
                    @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
            })
    public PersonVO createPerson(@RequestBody PersonVO personVO) {
        return PersonService.createPerson(personVO);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Put a person", description = "Put a person",
            tags = {"people"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = PersonVO.class))),
                    @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
            })
    public PersonVO updatePerson(@RequestBody PersonVO personVO){
        return PersonService.updatePerson(personVO);
    }   
    
    
    @DeleteMapping(value = "/del/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Delete a person", description = "Delete a person by id",
            tags = {"people"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content),
                    @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
            })
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){
        findById(id);
        PersonService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/v2",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Post a personV2", description = "Post a personV2",
            tags = {"people"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = PersonVO.class))),
                    @ApiResponse(responseCode = "204", description = "No Content", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
                    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
            })
    public PersonVO2 createPersonV2(@RequestBody PersonVO2 personVO) {

        return PersonService.createPerson2(personVO);
    }

}
            