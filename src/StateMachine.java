import java.util.ArrayList;

public class StateMachine {
    public StateMachine(){

    }

    public ArrayList<State> nextState(State thisState, String input){
        int state = thisState.getStates();
        ArrayList<State> stateList = new ArrayList<>();
        if(state == 0){

            if(input.equalsIgnoreCase("E")){
                State nextState = new State();
                nextState.copy(thisState);
                nextState.push("$");
                nextState.setStates(state+1);
                stateList.add(nextState);
                return stateList;
            }else{
                return null;
            }

        }else if(state == 1){

            if(input.equalsIgnoreCase("E")){

                State nextState = new State();
                nextState.copy(thisState);
                nextState.setStates(state+1);
                stateList.add(nextState);
                return stateList;

            }else if(input.equalsIgnoreCase("a")){

                State nextState1 = new State();
                nextState1.copy(thisState);
                nextState1.push("a");
                stateList.add(nextState1);
                State nextState2 = new State();
                nextState2.copy(thisState);
                nextState2.setStates(state+1);
                stateList.add(nextState2);
                return stateList;

            }else if(input.equalsIgnoreCase("b")){

                State nextState1 = new State();
                nextState1.copy(thisState);
                nextState1.push("b");
                stateList.add(nextState1);
                State nextState2 = new State();
                nextState2.copy(thisState);
                nextState2.setStates(state+1);
                stateList.add(nextState2);
                return stateList;

            }else{

                return null;

            }

        }else if(state == 2){

            if(input.equalsIgnoreCase("E")){

                State nextState = new State();
                nextState.copy(thisState);
                if(nextState.pop().equalsIgnoreCase("$")){
                    nextState.push("$");
                    nextState.setStates(state+1);
                    stateList.add(nextState);
                    return stateList;
                }else{
                    return null;
                }

            }else if(input.equalsIgnoreCase("a")){

                State nextState = new State();
                nextState.copy(thisState);
                if(nextState.pop().equalsIgnoreCase("a")){
                    stateList.add(nextState);
                    return stateList;
                }else{
                    return null;
                }

            }else if(input.equalsIgnoreCase("b")){

                State nextState = new State();
                nextState.copy(thisState);
                if(nextState.pop().equalsIgnoreCase("b")){
                    stateList.add(nextState);
                    return stateList;
                }else{
                    return null;
                }

            }else{

                return null;

            }

        }else if(state == 3){

            if(input.equalsIgnoreCase("E")){
                stateList.add(thisState);
                return stateList;
            }else{
                return null;
            }

        }else{

            return null;

        }

    }


}
