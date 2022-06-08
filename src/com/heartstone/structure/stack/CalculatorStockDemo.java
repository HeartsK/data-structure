package com.heartstone.structure.stack;

/**
 * @author code generator
 * @date 2022-06-01 9:47
 */
public class CalculatorStockDemo {

    public static void main(String[] args) {
        String expression = "70*2*2-5+1-5+3-4";
        int index = 0;
        String express = "";
        CalculatorArrayStack numStack = new CalculatorArrayStack(10);
        CalculatorArrayStack operatorStack = new CalculatorArrayStack(10);
        while (index <= expression.length() - 1) {
            char c = expression.substring(index, index + 1).charAt(0);
            if (CalculatorArrayStack.isOperator(c)) {
                //是操作符
                if (!operatorStack.isEmpty()) {
                    //比较操作符优先级
                    if (CalculatorArrayStack.priority(c) <= CalculatorArrayStack.priority(operatorStack.peek())) {
                        //先将数据抽出并将符号栈中的顶层符号进行预算
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int operator = operatorStack.pop();
                        int res = CalculatorArrayStack.calculate(num1, num2, operator);
                        numStack.push(res);
                    }
                }
                operatorStack.push(c);
            } else {
                //数字就直接放入
                //需要判断后一位是否还是数字，如果是就继续，知道碰到符号
                express = express + c;
                while (index < expression.length() - 1) {
                    char next = expression.substring(index + 1, index + 2).charAt(0);
                    if (CalculatorArrayStack.isOperator(next)) {
                        break;
                    } else {
                        express = express + next;
                        index++;
                    }
                }
                numStack.push(Integer.parseInt(express));
                express = "";
            }
            index++;
        }
        //进行同级别计算
        while (!operatorStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int operator = operatorStack.pop();
            int res = CalculatorArrayStack.calculate(num1, num2, operator);
            numStack.push(res);
        }
        System.out.printf("表达式%s的计算结果：%d\n", expression, numStack.pop());
    }
}

class CalculatorArrayStack {

    private int maxSize;

    private int[] stack;

    private int top = -1;

    public CalculatorArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    public static boolean isOperator(char operator) {
        return operator == '+' || operator == '-' ||
                operator == '*' || operator == '/';
    }

    public static int priority(int c) {
        int priority = 0;
        switch (c) {
            case '+':
            case '-':
                priority = 1;
                break;
            case '*':
            case '/':
                priority = 2;
                break;
        }
        return priority;
    }

    public static int calculate(int num1, int num2, int operator) {
        int res = 0;
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public int peek() {
        return this.stack[this.top];
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        this.top++;
        this.stack[this.top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = this.stack[this.top];
        this.top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d", i, stack[i]);
        }
    }

}
