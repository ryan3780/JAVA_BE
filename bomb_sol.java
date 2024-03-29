
public class bomb_sol {
    public static void main(String[] args) {
        String[][] arr = { { "0", "0", "0", "*", "0", "0" }, { "*", "0", "0", "*", "*", "0" },
                { "0", "0", "0", "*", "0", "0" }, { "0", "0", "0", "*", "*", "0" }, { "*", "0", "0", "*", "0", "0" } };

        int cnt = 0; // 선언은 1번만 하는것이 좋음
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                cnt = 0;

                /*
                 * if (arr[i][j].equals("*")) { // 지뢰 위치 고정 arr[i][j] = "*"; // 이미 있는 데이터를 다시
                 * 지정할 필요 없기에 제거 }
                 */

                if (!"*".equals(arr[i][j])) { // null이면 에러 날 수 있기에 null 이 아닌걸로 사용
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
            // System.out.println(); 한줄 무조건 엔터치고 시작하므로 변경
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
