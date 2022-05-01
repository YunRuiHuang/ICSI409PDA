import java.util.ArrayList;

/**
 * @Author Yunrui Huang
 * the state class hold the state and a stack
 */
public class State {
    private int states;
    private Stack stack;

    /**
     * the constructor of state class
     * set the state as 0 and empty stack
     */
    public State(){
        this.states = 0;
        this.stack = new Stack();
    }

    /**
     * get the state of this class
     * @return
     * the state
     */
    public int getStates() {
        return states;
    }

    /**
     * set the state of this class
     * @param states
     * the state to set
     */
    public void setStates(int states) {
        this.states = states;
    }

    /**
     * get the stack of this class
     * @return
     * the stack of this class
     */
    public Stack getStack() {
        return stack;
    }

    /**
     * set the stack of this class
     * @param stack
     * the stack use to set
     */
    public void setStack(Stack stack) {
        this.stack = stack;
    }

    /**
     * push a string in this stack
     * @param in
     * the string use to push in
     */
    public void push(String in){
        this.stack.push(in);
    }

    /**
     * pop the string from this stack
     * @return
     * the sting pop from stack
     */
    public String pop(){
        return this.stack.pop();
    }

    /**
     * copy another state to this state
     * @param state
     * the another state use to copy
     * @return
     * this state after copy
     */
    public State copy(State state){
        this.states = state.getStates();
        ArrayList<String> stack = state.getStack().getStack();
        this.stack = new Stack();
        for (int i = 0; i < stack.size(); i++) {
            this.stack.push(stack.get(i));
        }
        return this;
    }

    /**
     * override the toString method to print the state and stack
     * @return
     * the state and stack
     */
    public String toString(){
        return "State:" + this.states + this.stack.toString();
    }

}
