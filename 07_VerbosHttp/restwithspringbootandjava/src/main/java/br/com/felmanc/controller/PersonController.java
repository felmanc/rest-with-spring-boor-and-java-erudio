package br.com.felmanc.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.felmanc.model.Person;
import br.com.felmanc.services.PersonServices;

//@RestController: retorna um objeto e
//  o objeto e os dados do objeto são escritos diretamente na resposta HTTP, como JSON ou XML
@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonServices service;
  
  @RequestMapping(method=RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> findAll(){
    return service.findAll();
  }

  @RequestMapping(value = "/{id}",
      method=RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  /*@GetMapping(value = "/{id}"
      produces = MediaTyp.APP)*/
  public Person findById(
      @PathVariable(value = "id") String id)/* throws Exception*/{
    return service.findById(id);
  }

  @RequestMapping(method=RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Person create(
      @RequestBody Person person)/* throws Exception*/{
    return service.create(person);
  }

  @RequestMapping(method=RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Person update(
      @RequestBody Person person)/* throws Exception*/{
    return service.update(person);
  }

  @RequestMapping(value = "/{id}",
      method=RequestMethod.DELETE)
  public void delete(
      @PathVariable(value = "id") String id){
    service.delete(id);
  }

}
