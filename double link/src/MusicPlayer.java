import java.util.Scanner;

public class MusicPlayer {
    private Playlist playlist;

    public MusicPlayer() {
        this.playlist = new Playlist();
    }

    public void addSong(String title, String artist, int duration) {
        Song newSong = new Song(title, artist, duration);
        playlist.addSong(newSong);
    }

    public void removeSong(String title) {
        playlist.removeSong(title);
    }

    public void displayPlaylist() {
        playlist.displayPlaylist();
    }

    public void play() {
        playlist.play();
    }

    public void pause() {
        playlist.pause();
    }

    public void skip() {
        playlist.skip();
    }

    public void rewind() {
        playlist.rewind();
    }

    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Song\n2. Remove Song\n3. Display Playlist\n4. Play\n5. Pause\n6. Skip\n7. Rewind\n8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration (in seconds): ");
                    int duration = scanner.nextInt();
                    musicPlayer.addSong(title, artist, duration);
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();
                    musicPlayer.removeSong(removeTitle);
                    break;

                case 3:
                    musicPlayer.displayPlaylist();
                    break;

                case 4:
                    musicPlayer.play();
                    break;

                case 5:
                    musicPlayer.pause();
                    break;

                case 6:
                    musicPlayer.skip();
                    break;

                case 7:
                    musicPlayer.rewind();
                    break;

                case 8:
                    System.out.println("Exiting music player. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
