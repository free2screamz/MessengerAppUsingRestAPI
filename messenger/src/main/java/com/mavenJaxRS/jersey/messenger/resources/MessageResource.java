package com.mavenJaxRS.jersey.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mavenJaxRS.jersey.messenger.model.Message;
import com.mavenJaxRS.jersey.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessagebyId(@PathParam("messageid") Long id){
		return messageService.getMessage(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addSingleMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateSingleMessage(@PathParam("messageid") Long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageid") long id){
		messageService.removeMessage(id);
	}

}
