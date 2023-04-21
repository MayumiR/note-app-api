package com.example.demo.controller;
import com.example.demo.dao.NoteDAO;
import com.example.demo.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/note")
@CrossOrigin
public class NoteController {
    String FOLDER_PATH = "E:\\Personal\\AFSD\\practicals\\Assignments\\api\\demo1\\src\\main\\resources\\static\\images";
    @Autowired
    NoteDAO noteDAO;
    @PostMapping(path = "/save-note")
   // public Note saveNote(@RequestBody Note note) {
    public Note saveNote(@RequestParam(value = "title")String title,@RequestParam(value = "description")String description, @RequestParam(value = "image") MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        Note note = noteDAO.saveNote(new Note(title,description,"/images/"+file.getOriginalFilename(),new Date()));
        file.transferTo(new File(filePath));
        return note;
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
