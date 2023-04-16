package com.example.demo.controller;
import com.example.demo.dao.NoteDAO;
import com.example.demo.dto.NoteDto;
import com.example.demo.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/note")
@CrossOrigin
public class NoteController {
    @Autowired
    NoteDAO noteDAO;
    @PostMapping(path = "/save-note")
   // public Note saveNote(@RequestBody Note note) {
    public NoteDto saveNote(@RequestBody NoteDto note) {
        return noteDAO.saveNote(note);
    }
    @GetMapping(path = "/get-all-notes")
    public List<Note> getAllNotes(){
        return noteDAO.getAllNotes();
    }
    @GetMapping(path = "/get-note-by-id", params = "id")
    public Note getNoteById(@RequestParam(value = "id") Long noteId){
        return noteDAO.getNoteById(noteId);
    }
    @PutMapping(path = "/update-note")
    public String  updateNote(@RequestBody Note note){
        return noteDAO.updateNote(note);
    }
    @DeleteMapping(path = "/delete-note", params = "id")
    public String   deleteStudentById(@RequestParam(value = "id") Long noteId){
        return noteDAO.deleteStudentById(noteId);
    }
}
