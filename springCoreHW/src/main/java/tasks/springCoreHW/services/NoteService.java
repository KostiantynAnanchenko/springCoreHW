package tasks.springCoreHW.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import tasks.springCoreHW.entities.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Data
public class NoteService {

    public List<Note> notes = new ArrayList<>();


    public List<Note> listAll(){
       return this.notes;
    }

    public Note add(Note note){
        this.notes.add(note);
        UUID uniqueID = UUID.randomUUID();
        long longUniqueID = uniqueID.getMostSignificantBits();
        note.setId(longUniqueID);
        return note;

    }

    public void deleteById(long id) {
        Note noteToRemove = null;
        for (Note note : notes) {
            if (note.getId() == id) {
                noteToRemove = note;
                break;
            }
        }
        if (noteToRemove != null) {
            notes.remove(noteToRemove);
        }else {
            throw new IllegalArgumentException("Note with this ID is not exist.");
        }
    }

    public void update(Note note) {
        for (Note findNote : notes) {
            if (findNote.getId() == note.getId()) {
                findNote.setTitle(note.getTitle());
                findNote.setContent(note.getContent());
            }
        }
    }

    public Note getById(long id) {
        Note result = null;
        for (Note note : notes) {
            if (note.getId() == id) {
                result = note;
            }
        }
        if (result != null) {
            return result;
        }else{
            throw new IllegalArgumentException("Note with this ID is not exist.");
        }
    }




}
