package com.example.demo.dao;

import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteDAO {
    @Autowired
    NoteRepository noteRepo;

  //  public Note saveNote(Note note){
    //public NoteDto saveNote(NoteDto note){
    public Note saveNote(Note note){
       // return noteRepo.save(note);
        return noteRepo.save(note);
       // return noteRepo.save(note.toEntity()).toDto();

    }

    public List<Note> getAllNotes(){
        List<Note> notes = new ArrayList<Note>();
        noteRepo.findAll().forEach(note -> notes.add(note));
        return notes;
    }

    public Note getNoteById(Long id){
        return noteRepo.findById(id).get();
    }


    public String updateNote(Note note) {
        if (noteRepo.existsById(note.getId())) {
            noteRepo.save(note);
            return "Note  updated successfully";
        } else {
            return "Cannot found note for the given id";
        }
    }

    public String deleteStudentById(Long noteId) {
        if (noteRepo.existsById(noteId)) {
            noteRepo.deleteById(noteId);
            return "Note deleted successfully";
        } else {
            return "Cannot found note for the given id";
        }
    }

}
