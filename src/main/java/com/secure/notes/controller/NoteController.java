package com.secure.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.notes.models.Note;
import com.secure.notes.services.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

	 private final NoteService noteService;

	    // Constructor Injection ✅
	    public NoteController(NoteService noteService) {
	        this.noteService = noteService;
	    }

	@PostMapping
	public ResponseEntity<Note> createNote(@RequestBody String content,
			@AuthenticationPrincipal UserDetails userDetails ) {
		System.out.println("username===="+ userDetails.getUsername());
		Note noteCreated =noteService.createNoteForUser(userDetails.getUsername(), content);		
		
		return new ResponseEntity<>(noteCreated,HttpStatus.OK);
	}
	
	@PutMapping("/{noteId}")
	public ResponseEntity<Note> updateNote(@PathVariable Long noteId, @RequestBody String content,
			@AuthenticationPrincipal UserDetails userDetails ) {
		System.out.println("username===="+ userDetails.getUsername());
		Note noteUpdated =noteService.updateNoteForUser(noteId, content,userDetails.getUsername());		
		
		return new ResponseEntity<>(noteUpdated,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Note>> getNote(@AuthenticationPrincipal UserDetails userDetails ) {
		System.out.println("username===="+ userDetails.getUsername());
		List<Note> personalNotes =noteService.getNotesForUser(userDetails.getUsername());		
		
		return new ResponseEntity<>(personalNotes,HttpStatus.OK);
	}
	@DeleteMapping("/{noteId}")
	public ResponseEntity<String> deleteNote(@PathVariable Long noteId,
			@AuthenticationPrincipal UserDetails userDetails ) {
		System.out.println("username===="+ userDetails.getUsername());
		noteService.deleteNoteForUser(noteId, userDetails.getUsername());		
		
		return new ResponseEntity<>("Note Deleted",HttpStatus.OK);
	}

}
