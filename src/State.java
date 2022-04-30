import java.util.ArrayList;

public class State {
    private int states;
    private Stack stack;

    public State(){
        this.states = 0;
        this.stack = new Stack();
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public void push(String in){
        this.stack.push(in);
    }

    public String pop(){
        return this.stack.pop();
    }

    public State copy(State state){
        this.states = state.getStates();
        ArrayList<String> stack = state.getStack().getStack();
        this.stack = new Stack();
        for (int i = 0; i < stack.size(); i++) {
            this.stack.push(stack.get(i));
        }
        return this;
    }

    public String toString(){
        return "State:" + this.states + this.stack.toString();
    }

}
