import java.util.*;
class PvP{
    char board[][]={{'0','0','0'},{'0','0','0'},{'0','0','0'}};
    int gtally[]={0,0,0};
    void displayBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='0'){
                    System.out.print(" ");
                }
                else{
                    System.out.print(board[i][j]);
                }
                if(j!=2){
                    System.out.print("|");
                }
                else{
                    System.out.println();
                }
            }
            System.out.println("_ _ _");
        }
    }
    int check(char sign){
        if((board[0][0]==sign && board[0][1]==sign && board[0][2]==sign)||(board[0][0]==sign && board[1][0]==sign && board[2][0]==sign)||(board[0][0]==sign && board[1][1]==sign && board[2][2]==sign)||(board[1][0]==sign && board[1][1]==sign && board[1][2]==sign)||(board[2][0]==sign && board[2][1]==sign && board[2][2]==sign)||(board[2][0]==sign && board[1][1]==sign && board[0][2]==sign)||(board[2][1]==sign && board[1][1]==sign && board[0][1]==sign)||(board[2][2]==sign && board[1][2]==sign && board[0][2]==sign)){
            return 1;
        }
        else{
            return 0;
        }
    }
    void runGame(){
        Scanner sc=new Scanner(System.in);
        int n=0,m=0;
        int wcounter=0,mcounter=0;
        char p1sign='X',p2sign='O';
        do{
            System.out.println("\033[H\033[2J");
            System.out.println("Game tally:\n "+"Player1 wins: "+gtally[0]+"\n Player2 wins: "+gtally[1]+"\n Draws: "+gtally[2]);
            displayBoard();
            System.out.print("X for Player1, O for Player2 turn: ");
            int uerror=0;
            while(mcounter<9){
                if(uerror==0){
                System.out.println("Player1's Turn: ");
                System.out.print("Enter the index: ");
                n=sc.nextInt();
                m=sc.nextInt();
                if(board[n][m]!='0'){
                    System.out.println("Cell not empty: Re-enter index");
                    continue;
                }
                board[n][m]=p1sign;
                ++mcounter;
                displayBoard();
                wcounter=check(p1sign);
                if(wcounter!=0){
                    System.out.println("Player1 wins!");
                    ++gtally[0];
                    break;
                }
                if(mcounter==9){
                    break;
                }
                }
                uerror=0;
                System.out.println("Player2's Turn: ");
                System.out.print("Enter the index: ");
                n=sc.nextInt();
                m=sc.nextInt();
                if(board[n][m]!='0'){
                    System.out.println("Cell not empty: Re-enter index");
                    uerror=1;
                    continue;
                }
                board[n][m]=p2sign;
                ++mcounter;
                displayBoard();
                wcounter=check(p2sign);
                if(wcounter!=0){
                    System.out.println("Player2 wins!");
                    ++gtally[1];
                    break;
                }
            }
            System.out.print("Do you want to play a new game: 0:to return to original menu , Any character: to new game: ");
            char k=sc.next().charAt(0);
            if(k=='0'){
                System.out.println("Thanks for playing!BYE!");
                break;
            }
            char board1[][]={{'0','0','0'},{'0','0','0'},{'0','0','0'}};
            board=board1;
            wcounter=0;
            mcounter=0;
        }while(true);
    }
}
class PvC{
    char board[][]={{'0','0','0'},{'0','0','0'},{'0','0','0'}};
    int gtally[]={0,0,0};
    void displayBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='0'){
                    System.out.print(" ");
                }
                else{
                    System.out.print(board[i][j]);
                }
                if(j!=2){
                    System.out.print("|");
                }
                else{
                    System.out.println();
                }
            }
            System.out.println("_ _ _");
        }
    }
    int check(char sign){
        if((board[0][0]==sign && board[0][1]==sign && board[0][2]==sign)||(board[0][0]==sign && board[1][0]==sign && board[2][0]==sign)||(board[0][0]==sign && board[1][1]==sign && board[2][2]==sign)||(board[1][0]==sign && board[1][1]==sign && board[1][2]==sign)||(board[2][0]==sign && board[2][1]==sign && board[2][2]==sign)||(board[2][0]==sign && board[1][1]==sign && board[0][2]==sign)||(board[2][1]==sign && board[1][1]==sign && board[0][1]==sign)||(board[2][2]==sign && board[1][2]==sign && board[0][2]==sign)){
            return 1;
        }
        else{
            return 0;
        }
    }
    void moveComp(char csign,char usign){
        //computer advantage:
        for(int i=0;i<3;i++){
            if((board[i][0]==csign && board[i][1]==csign && board[i][2]=='0')||(board[i][0]==csign && board[i][1]=='0' && board[i][2]==csign)||(board[i][0]=='0' && board[i][1]==csign && board[i][2]==csign)){
                if(board[i][2]=='0'){
                    board[i][2]=csign;
                }
                else if(board[i][1]=='0'){
                    board[i][1]=csign;
                }
                else{
                    board[i][0]=csign;
                }
                return;
            }
            if((board[0][i]==csign && board[1][i]==csign && board[2][i]=='0')||(board[0][i]==csign && board[1][i]=='0' && board[2][i]==csign)||(board[0][i]=='0' && board[1][i]==csign && board[2][i]==csign)){
                if(board[2][i]=='0'){
                    board[2][i]=csign;
                }
                else if(board[1][i]=='0'){
                    board[1][i]=csign;
                }
                else{
                    board[0][i]=csign;
                }
                return;
            }
        }
        if(board[0][0]==csign && board[1][1]==csign && board[2][2]=='0'){
            board[2][2]=csign;
            return;
        }
        if(board[1][1]==csign && board[2][2]==csign && board[0][0]=='0'){
            board[0][0]=csign;
            return;
        }
        if(board[0][2]==csign && board[1][1]==csign && board[2][0]=='0'){
            board[2][0]=csign;
            return;
        }
        if(board[0][2]=='0' && board[1][1]==csign && board[2][0]==csign){
            board[0][2]=csign;
            return;
        }
        //end of computer advantage
        //user advantage
        for(int i=0;i<3;i++){
            if((board[i][0]==usign && board[i][1]==usign && board[i][2]=='0')||(board[i][0]==usign && board[i][1]=='0' && board[i][2]==usign)||(board[i][0]=='0' && board[i][1]==usign && board[i][2]==usign)){
                if(board[i][2]=='0')
                    board[i][2]=csign;
                else if(board[i][1]=='0')
                    board[i][1]=csign;
                else
                    board[i][0]=csign;
                return;
            }
            if((board[0][i]==usign && board[1][i]==usign && board[2][i]=='0')||(board[0][i]==usign && board[1][i]=='0' && board[2][i]==usign)||(board[0][i]=='0' && board[1][i]==usign && board[2][i]==usign)){
                if(board[2][i]=='0')
                    board[2][i]=csign;
                else if(board[1][i]=='0')
                    board[1][i]=csign;
                else
                    board[0][i]=csign;
                return;
            }
        }
        if(board[0][0]==usign && board[1][1]==usign && board[2][2]=='0'){
            board[2][2]=csign;
            return;
        }
        if(board[1][1]==usign && board[2][2]==usign && board[0][0]=='0'){
            board[0][0]=csign;
            return;
        }
        if(board[0][2]==usign && board[1][1]==usign && board[2][0]=='0'){
            board[2][0]=csign;
            return;
        }
        if(board[0][2]=='0' && board[1][1]==usign && board[2][0]==usign){
            board[0][2]=csign;
            return;
        }
        //end of user advantage
        //random move
        while(true){
            Random rand=new Random();
            int n=rand.nextInt(3);
            int m=rand.nextInt(3);
            if(board[n][m]=='0'){
                board[n][m]=csign;
                return;
            }
        }
        //end of random move
    }
    void runGame(){
        Scanner sc=new Scanner(System.in);
        int wcounter=0,mcounter=0;
        char usign,csign;
        do{
            System.out.println("\033[H\033[2J");
            System.out.println("Game tally:\n "+"User wins: "+gtally[0]+"\n CPU wins: "+gtally[1]+"\n Draws: "+gtally[2]);
            displayBoard();
            System.out.print("Choose a character: X for 1st turn, O for 2nd turn: ");
            usign=sc.next().charAt(0);
            switch(usign){
                case 'X': csign='O';break;
                case 'O': csign='X';break;
                default: System.out.println("Wrong input:Re-enter");continue;
            }
            int uerror=0;
            if(usign=='X'){
                while(mcounter<9){
                    System.out.print("Enter the index: ");
                    int n=sc.nextInt();
                    int m=sc.nextInt();
                    if(board[n][m]!='0'){
                        System.out.println("Cell not empty: Re-enter index");
                        continue;
                    }
                    board[n][m]=usign;
                    ++mcounter;
                    displayBoard();
                    wcounter=check(usign);
                    if(wcounter!=0){
                        System.out.println("User wins!");
                        ++gtally[0];
                        break;
                    }
                    if(mcounter==9){
                        break;
                    }
                    System.out.println("CPU's Move:");
                    moveComp(csign,usign);
                    displayBoard();
                    ++mcounter;
                    wcounter=check(csign);
                    if(wcounter!=0){
                        System.out.println("CPU wins!");
                        ++gtally[1];
                        break;
                    }
                }
            }
            else{
                while(mcounter<9){
                    if(uerror==0){
                        System.out.println("CPU's Move:");
                        moveComp(csign,usign);
                        displayBoard();
                        ++mcounter;
                        wcounter=check(csign);
                        if(wcounter!=0){
                            System.out.println("CPU wins!");
                            ++gtally[1];
                            break;
                        }
                        if(mcounter==9){
                            break;
                        }
                    }
                    uerror=0;
                    System.out.println("User's move");
                    System.out.print("Enter the index: ");
                    int n=sc.nextInt();
                    int m=sc.nextInt();
                    if(board[n][m]!='0'){
                        System.out.println("Cell not empty: Re-enter index");
                        uerror=1;
                        continue;
                    }
                    board[n][m]=usign;
                    ++mcounter;
                    displayBoard();
                    wcounter=check(usign);
                    if(wcounter!=0){
                        System.out.println("User wins!");
                        ++gtally[0];
                        break;
                    }
                }
            }
            if(wcounter==0){
                System.out.println("Match draw!");
                ++gtally[2];
            }
            System.out.print("Do you want to play a new game: 0:to return to original menu , Any character: to new game ");
            char k=sc.next().charAt(0);
            if(k=='0'){
                System.out.println("Thanks for playing!BYE!");
                break;
            }
            char board1[][]={{'0','0','0'},{'0','0','0'},{'0','0','0'}};
            board=board1;
            wcounter=0;
            mcounter=0;
        }while(true);
    }
}
public class Tic_Tac_Toe{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("\033[H\033[2J");
            System.out.print("Menu:\n1.PvP\n2.PvC\nPress any button to exit\nchocie:");
            char c=sc.next().charAt(0);
            if(c=='1'){
                new PvP().runGame();
            }
            else if(c=='2'){
                new PvC().runGame();
            }
            else{
                break;
            }
        }while(true);
    }
}