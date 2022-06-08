package com.heartstone.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author code generator
 * @date 2022-06-02 9:50
 */
public class RevPolishNotation {

    public static void main(String[] args) {

        /*String suffixExpression = "1 2 3 + 4 * + 5 -";
        List<String> suffixList = Arrays.asList(suffixExpression.split(" "));
        int calculate = calculate(suffixList);
        System.out.println(calculate);*/

        String infixExpression = "1+2*3-5";
        List<String> suffixList = transferSuffix(infixExpression);
        System.out.println(suffixList);
    }

    public static List<String> transferSuffix(String infixExpression){
        List<String> ls = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < infixExpression.length()){
            String item = infixExpression.substring(index, index + 1);
            if (item.matches("\\d+")){
                ls.add(item);
            }else {
                //符号
                if (stack.isEmpty()){
                    stack.push(item);
                }else if (item.equals("(")){
                    stack.push(item);
                }else if (item.equals(")")){
                    while (!stack.peek().equals("(")){
                        ls.add(stack.pop());
                    }
                    stack.pop();
                }else if (Priority.getPriority(item) > Priority.getPriority(stack.peek())){
                    stack.push(item);
                }else if (Priority.getPriority(item) <= Priority.getPriority(stack.peek())){
                    ls.add(stack.pop());
                    stack.push(item);
                }
            }
            index++;
        }
        while (stack.size() > 0){
            ls.add(stack.pop());
        }

        return ls;
    }

    public static int calculate(List<String> suffixList){
        Stack<Integer> stack = new Stack<Integer>();
        for (String item: suffixList) {
            //通过正则表达式判断一位或多位数字
            if (item.matches("\\d+")){
                stack.push(Integer.parseInt(item));
            }else if (item.equals("+")){
                //是运算符则进行弹出最顶端的两个进行运算
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int res = num1 + num2;
                stack.push(res);
            }else if (item.equals("-")){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int res = num2 - num1;
                stack.push(res);
            }else if (item.equals("*")){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int res = num1 * num2;
                stack.push(res);
            }else if (item.equals("/")){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int res = num2 / num1;
                stack.push(res);
            }
        }
        return stack.pop();
    }
}

class Priority{

    private final static int PLU = 1;
    private final static int MIN = 1;
    private final static int MUL = 2;
    private final static int DIV = 2;

    public static int getPriority(String operator){
        int res = 0;
        switch (operator){
            case "+":
                res = PLU;
                break;
            case "-":
                res = MIN;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}