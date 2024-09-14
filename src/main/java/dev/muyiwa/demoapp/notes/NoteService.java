package dev.muyiwa.demoapp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> getNoteById(UUID id) {
        return noteRepository.findById(id);
    }

    public Note updateNoteById() {
        return null;
    }

    public void deleteNoteById(UUID id) {
        noteRepository.deleteById(id);
    }

    public List<NoteDto> getNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream()
                .map(Note::toDto)
                .collect(Collectors.toList());
    }

}
