import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song {
        String typeList;
        String name;
        String length;

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> listSongs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputSongArr = scanner.nextLine().split("_");
            String inputType = inputSongArr[0];
            String inputName = inputSongArr[1];
            String inputTime = inputSongArr[2];

            Song currentSong = new Song();
            currentSong.setTypeList(inputType);
            currentSong.setName(inputName);
            currentSong.setLength(inputTime);

            listSongs.add(currentSong);
        }
        String command = scanner.nextLine();

        if ("all".equals(command)) {
            for (Song item : listSongs) {
                System.out.println(item.getName());
            }
        } else {
            for (Song item : listSongs) {
                if (command.equals(item.getTypeList())) {
                    System.out.println(item.getName());
                }
            }
        }
    }
}
