/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitecturas.testWS.services;

import co.edu.unipiloto.arquitecturas.testWS.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("service")
public class Service {
    private static Map<Integer, Persona> persons=new HashMap<>();
    
    static{
        for(int i=0;i<10;i++){
            Persona persona= new Persona();
            int id=i+1;
            persona.setId(id);
            persona.setFullName("Mipersona "+ id);
            persona.setAge(new Random().nextInt(20+id));
            persons.put(id, persona);
        }
    }
    
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Persona getPersonByIdXML(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersonByIdJson(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getAllPersonsInJson(){
        return new ArrayList<Persona>(persons.values());
    }
    
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Persona> getAllPersonsInXML(){
        return new ArrayList<Persona>(persons.values());
    }
    
    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Persona addPersonInJson(Persona person){
        System.out.println(person.getId());
        persons.put(new Integer(person.getId()), person);
        return person;
    }
    
    @GET
    @Path("/getSalarioPromedioXML")
    @Produces(MediaType.APPLICATION_XML)
    public int getSalarioPromedioXML() {
         int salarioTotal = 0;
         for (Persona persona : persons.values()) {
             salarioTotal += persona.getSalario();
         }
        return salarioTotal / persons.size();
    }
    
    @GET
    @Path("/sumarSalarios")
    @Produces(MediaType.APPLICATION_JSON)
    public int sumarSalarios() {
        int sumaSalarios = 0;
        for (Persona persona : persons.values()) {
            sumaSalarios += persona.getSalario();
        }
        return sumaSalarios;
    }
    
    @POST
    @Path("/addPersona")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Persona addPersona(Persona persona) {
        int newId = persons.size() + 1; 
        persona.setId(newId);
        persons.put(newId, persona);
        return persona;
    }
    
    
    /*@GET
    @Path("getAllPersonsInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getAllPersonsInJSON(){
        return new ArrayList<Persona>(persons.values());
    }
    
    @POST
    @Path("addPerson/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Persona> addPerson(List<Persona> pr){
        for(Persona persona:pr){
            persons.put(persona.getId(), persona);
        }
        return new ArrayList<Persona>(persons.values());
    }*/
    
}
