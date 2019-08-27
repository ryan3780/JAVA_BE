
public class bomb {
    public static void main(String[] args) {
        String[][] arr = { { "0", "0", "0", "*", "0", "0" }, { "*", "0", "0", "*", "*", "0" },
                { "0", "0", "0", "*", "0", "0" }, { "0", "0", "0", "*", "*", "0" }, { "*", "0", "0", "*", "0", "0" } };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // System.out.print(arr[i][j] + " ");

                if (arr[i][j].equals("*")) { // 지뢰 위치 고정
                    arr[i][j] = "*";
                } else {
                    int cnt = 0;
                    if (i > 0 && j > 0 && arr[i - 1][j - 1].equals("*")) { // 좌측 위
                        cnt++;
                    }
                    if (i > 0 && arr[i - 1][j].equals("*")) { // 위
                        cnt++;
                    }
                    if (i > 0 && j < arr[0].length - 1 && arr[i - 1][j + 1].equals("*")) { // 오른쪽 위

                        cnt++;
                    }
                    if (j < arr[0].length - 1 && arr[i][j + 1].equals("*")) { // 오른쪽
                        cnt++;
                    }
                    if (i < arr.length - 1 && j < arr[0].length - 1 && arr[i + 1][j + 1].equals("*")) { // 오른쪽 아래
                        cnt++;
                    }
                    if (i < arr.length - 1 && arr[i + 1][j].equals("*")) { // 아래
                        cnt++;
                    }
                    if (i < arr.length - 1 && j > 0 && arr[i + 1][j - 1].equals("*")) { // 아래 왼쪽
                        cnt++;
                    }
                    if (j > 0 && arr[i][j - 1].equals("*")) { // 왼쪽
                        cnt++;
                    }
                    arr[i][j] = Integer.toString(cnt);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) { // 바뀐 값들 출력
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
