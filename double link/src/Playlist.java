public class Playlist {
    private Node head;
    private Node tail;
    private Node current; 

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        System.out.println("Song added to the playlist: " + song.title);
    }

    public void removeSong(String title) {
        Node current = head;

        while (current != null) {
            if (current.song.title.equals(title)) {
                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }

                System.out.println("Song removed from the playlist: " + title);

                if (current == this.current) {
                    this.current = this.current.next; 
                }

                return;
            }

            current = current.next;
        }

        System.out.println("Song not found in the playlist: " + title);
    }

    public void displayPlaylist() {
        System.out.println("Playlist:");

        Node current = head;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }

        System.out.println();
    }

    public void play() {
        if (current != null) {
            System.out.println("Now playing: " + current.song.title);
        } else {
            System.out.println("Playlist is empty. Add songs to start playing.");
        }
    }

    public void pause() {
        System.out.println("Playback paused.");
    }

    public void skip() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Skipped to: " + current.song.title);
        } else {
            System.out.println("End of the playlist. Cannot skip.");
        }
    }

    public void rewind() {
        if (current != null && current.previous != null) {
            current = current.previous;
            System.out.println("Rewinded to: " + current.song.title);
        } else {
            System.out.println("Beginning of the playlist. Cannot rewind.");
        }
    }
}
