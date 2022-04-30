import java.util.ArrayList;
import java.util.Scanner;

public class PDAProcess {

    private StateMachine stateMachine;
    private ArrayList<State> stateArrayList;
    private ArrayList<State> nextStateArrayList;

    public PDAProcess(){

        this.stateArrayList = new ArrayList<>();
        this.stateMachine = new StateMachine();
        this.nextStateArrayList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String str = "";

        while(true){
            System.out.println("type in a palindrome word here : (basic on (a,b)* ,also type quit to left");
            str = scanner.nextLine();
            str = str.replace(" ","");
            if(str.equalsIgnoreCase("quit")){
                break;
            }
            PDA(str.split(""));

            this.stateArrayList = new ArrayList<>();
            this.nextStateArrayList = new ArrayList<>();
        }

    }

    private void PDA(String[] input){
        State newState = new State();
        stateArrayList = this.stateMachine.nextState(newState,"E");
        for (int i = 0; i < input.length; i++) {
            ArrayList<State> newStateList = new ArrayList<>();

            for (int j = 0; j < stateArrayList.size(); j++) {
                newStateList = stateMachine.nextState(stateArrayList.get(j),"E");
                if(!(newStateList == null)){
                    for (int k = 0; k < newStateList.size(); k++) {
//                        System.out.println(newStateList.get(k).toString());
                        nextStateArrayList.add(new State().copy(newStateList.get(k)));
                    }
                }

            }

            if(!(nextStateArrayList == null || nextStateArrayList.isEmpty())){
                for (int j = 0; j < nextStateArrayList.size(); j++) {
                    stateArrayList.add(new State().copy(nextStateArrayList.get(j)));
//                    System.out.print("\nState:" + stateArrayList.get(j).getStates() + stateArrayList.get(j).getStack().toString());
                }
                nextStateArrayList.clear();
            }

            for (int j = 0; j < stateArrayList.size(); j++) {
                newStateList = stateMachine.nextState(stateArrayList.get(j),input[i]);
                if(!(newStateList == null)){
                    for (int k = 0; k < newStateList.size(); k++) {
                        nextStateArrayList.add(new State().copy(newStateList.get(k)));
                    }
                }

            }


            stateArrayList.clear();
            if(!(nextStateArrayList == null || nextStateArrayList.isEmpty())){
                for (int j = 0; j < nextStateArrayList.size(); j++) {
                    stateArrayList.add(new State().copy(nextStateArrayList.get(j)));
//                    System.out.print("\nState:" + stateArrayList.get(j).getStates() + stateArrayList.get(j).getStack().toString());
                }
                nextStateArrayList.clear();
            }
//            System.out.println();

        }

        if(!stateArrayList.isEmpty()){
            ArrayList<State> newStateList = new ArrayList<>();
            for (int j = 0; j < stateArrayList.size(); j++) {
                newStateList = stateMachine.nextState(stateArrayList.get(j),"E");
                if(!(newStateList == null)){
                    for (int k = 0; k < newStateList.size(); k++) {
                        nextStateArrayList.add(new State().copy(newStateList.get(k)));
                    }
                }

            }
            stateArrayList.clear();
            if(!(nextStateArrayList == null || nextStateArrayList.isEmpty())){
                for (int j = 0; j < nextStateArrayList.size(); j++) {
                    stateArrayList.add(new State().copy(nextStateArrayList.get(j)));
//                    System.out.print(stateArrayList.get(j).getStates() + stateArrayList.get(j).getStack().toString());
                }
                nextStateArrayList.clear();
            }
        }

        if(stateArrayList.isEmpty()){
            System.out.println("this word not accept");
        }else{
            for (int i = 0; i < stateArrayList.size(); i++) {
                if(stateArrayList.get(i).getStates() == 3){
                    System.out.println("this word accept");
                    return;
                }
            }
            System.out.println("this word not accept");
        }

    }
}
