/*
    |        |        |    
   <=>       |        |    
  <===>      |        |    
 <=====>     |        |    
<=======>    |        |    
[   0   ][   1   ][   2   ]

Pindahkan Cincin
Dari >> 
Ke >> 
*/
import java.util.Scanner;
import java.util.Arrays;

class Main {
  static void print(String str) {
    System.out.print(str);
  }
  static void println(String str) {
    System.out.println(str);
  }
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int cincin = 4;
    int tiang = 3;
    int[][] hanoiCincin = new int[tiang][cincin+1];
    hanoiCincin[0] = new int[]{0,1,2,3,4};
    int[] tumpukan = new int[]{0,1,2,3,4};
    String[] objCincin = new String[] {
      "    |    ",
      "   <=>   ",
      "  <===>  ",
      " <=====> ",
      "<=======>"
    };
    boolean lengkap = false;
    while(lengkap == false) {
      clearScreen();
      for(int i=0; i<=cincin; i++) {
        for(int j=0; j<tiang; j++) {
          int x = hanoiCincin[j][i];
          print(objCincin[x]);
        }
        println("");
      }
      println("[   0   ][   1   ][   2   ]\n");
      if(Arrays.equals(hanoiCincin[2], tumpukan)) {
        println("Tumpukan Cincin Berhasil Dipindahkan");
        break;
      }
      println("Pindahkan Cincin");
      print("Dari >> ");
      int awal = scn.nextInt();
      print("Ke >> ");
      int tujuan = scn.nextInt();
      for(int i=0; i<=cincin; i++) {
        int v = hanoiCincin[awal][i];
        if(v > 0) {
          if(hanoiCincin[tujuan][cincin] == 0) {
            hanoiCincin[tujuan][cincin] = v;
            hanoiCincin[awal][i] = 0;
          }
          else {
            for(int j=0; j<=cincin; j++) {
              int v2 = hanoiCincin[tujuan][j];
              if(v2 > 0 && v < v2) {
                hanoiCincin[tujuan][j-1] = v;
                hanoiCincin[awal][i] = 0;
                break;
              }
            }
          }
          break;
        }
      }
    }
  }
}
