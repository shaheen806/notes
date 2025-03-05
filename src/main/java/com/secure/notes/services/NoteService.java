package com.secure.notes.services;

import java.util.List;

import com.secure.notes.models.Note;

public interface NoteService {

	Note createNoteForUser(String username, String content);

	Note updateNoteForUser(Long noteId, String content, String username);

	List<Note> getNotesForUser(String username);

	void deleteNoteForUser(Long noteId, String username);
}
