package lesson1_19_02_15;

import java.io.*;
import java.util.*;

public class Message
{
  private String m_strMsg;  // текущее сообщение

  // Создает новый контейнер с текстом
  public Message(String strMsg) {
    setMessage(strMsg);
  }
  
  //Инициализация пустой строкой
  public Message() {
      setMessage("");
  }

  // Извлекает сообщение
  public String getMessage() {
    return m_strMsg;
  }

  // Устанавливает сообщение
  public final void setMessage(String strMsg) {
    m_strMsg = strMsg;
  }
  
  //Считывает сообщение
  public void read() {
    try {
        m_strMsg =  new BufferedReader(new InputStreamReader(System.in)).readLine();
    } catch (IOException e) {
        System.out.println("Cannot read message: " + e.getMessage());
        m_strMsg = new String();
    }
  }
  
  //Считает количество вхождений символа chr в сообщение
  public int count(char chr) {
      int iCount = 0;
      
      for (int i = 0; i < m_strMsg.length(); i ++) {
          if (m_strMsg.charAt(i) == chr) {
              iCount++;
          }
      }
      
      return iCount;
  }

  //Разворачивает строку
  public String reverse() {
        String strReversed = new String();
        for (int i = m_strMsg.length()-1; i >= 0; i--) {
            strReversed += Character.toString(m_strMsg.charAt(i));
        }
        
        return strReversed;
    }
  
  //Сдвигает коды всех символов на shift
  public String encode(int shift) {
      String strEncoded = new String("");
      
      for (int i = 0; i < m_strMsg.length(); i++) {
          char tempChar = (char)((int)m_strMsg.charAt(i) + shift);
          
          strEncoded += Character.toString(tempChar);
      }
      
      return strEncoded;
  }
  
  //Считаем количество слов (пробелов)
  public int countWords() {
      int iCount = 1;
      
      for (int i = 0; i < m_strMsg.length(); i++) {
          if (m_strMsg.charAt(i) == ' ') {
              iCount++;
          }
      }
      
      return iCount;
  }
  
  //Проверяет правильность расстановки скобок ()[]{}<> в сообщении
  public boolean isValid() {
      Stack bracketStack = new Stack();
      
      for (char symbol : m_strMsg.toCharArray()) {
          if ( symbol == '[' || symbol == '{' || symbol == '(' || symbol == '<') {
              bracketStack.push(symbol);
          } else if (symbol == ']' || symbol == '}' || symbol == ')' 
                     || symbol == '>') {
              try {
                  char topElement = (char)bracketStack.pop();
                  if (symbol == ']' && topElement != '[' ||
                      symbol == '}' && topElement != '{' ||
                      symbol == ')' && topElement != '(' ||
                      symbol == '>' && topElement != '<'){
                      return false;
                  }
              } catch (EmptyStackException stackIsEmpty) {
                  return false;
              }
          }
          
      }
      
      return bracketStack.isEmpty();
  }
}