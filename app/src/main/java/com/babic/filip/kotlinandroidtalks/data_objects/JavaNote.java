package com.babic.filip.kotlinandroidtalks.data_objects;

/**
 * Created by Filip Babic @cobe
 */

public class JavaNote {

    private String title;
    private String text;
    private String timestamp;

    public JavaNote(String title, String text, String timestamp) {
        this.title = title;
        this.text = text;
        this.timestamp = timestamp;
    }

    public JavaNote() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaNote note = (JavaNote) o;

        if (!title.equals(note.title)) return false;
        if (!text.equals(note.text)) return false;
        return timestamp.equals(note.timestamp);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + timestamp.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JavaNote{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
