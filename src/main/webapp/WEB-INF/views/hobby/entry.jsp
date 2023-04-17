<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html>
  <head>
    <title>Table Example</title>
<style>
  /* CSS 스타일링 */
  #container {
    margin: 0 auto; /* 가운데 정렬 */
    width: 700px; /* 너비 줄이기 */
    position:absolute;
    top:300px;
    left:400px;
  }

  table {
    border-collapse: separate;
    border-spacing: 0px;
    width: 100%;
    table-layout: fixed;
    border-radius: 10px;
    overflow: hidden;
  }

  td, th {
    border: 1px solid black;
    border-color: rgba(0, 0, 0, 0.3); /* 열구분선 색상 */
    padding: 5px;
    text-align: left; 
  
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  td:first-child, th:first-child {
    border-left: none;
  }

  td:last-child, th:last-child {
    border-right: none;
  }

  tr:first-child td:first-child {
    border-top-left-radius: 10px;
  }

  tr:first-child td:last-child {
    border-top-right-radius: 10px;
  }

  tr:last-child td:first-child {
    border-bottom-left-radius: 10px;
  }

  tr:last-child td:last-child {
    border-bottom-right-radius: 10px;
  }

  tr:last-child td {
    border-bottom: 1px solid rgba(0, 0, 0, 0.3); /* 마지막 행 경계선 색상 */
  }

  tr:nth-child(even) td {
    background-color: #f2f2f2;
  }
.back-button {
  position: absolute;
  top: 105%;
  right: 0;
}
</style>
  </head>
  <body>
    <div id="container">
      <table>
      <div class="table-title">
  		<h2>참가자 명단 확인</h2>
	  </div>
        <tbody>
	 <tr>
            <td colspan="5">참가명단</td>
          </tr>
<tr>
            <td colspan="5">종목</td>
          </tr>
<tr>
            <td colspan="5"></td>
          </tr>
	          <tr>
            <td>아이디</td>
            <td>이름</td>
            <td>연락처</td>
            <td>성별</td>
            <td>랭크</td>
          </tr>
          <tr>
            <td>Cell 6</td>
            <td>Cell 7</td>
            <td>Cell 8</td>
            <td>Cell 9</td>
            <td>Cell 10</td>
          </tr>
          <tr>
            <td>Cell 11</td>
            <td>Cell 12</td>
            <td>Cell 13</td>
            <td>Cell 14</td>
            <td>Cell 15</td>
          </tr>
          <tr>
            <td>Cell 16</td>
            <td>Cell 17</td>
            <td>Cell 18</td>
            <td>Cell 19</td>
            <td>Cell 20</td>
          </tr>
          <tr>
            <td>Cell 21</td>
            <td>Cell 22</td>
            <td>Cell 23</td>
            <td>Cell 24</td>
            <td>Cell 25</td>
          </tr>
          <tr>
            <td>Cell 26</td>
            <td>Cell 27</td>
            <td>Cell 28</td>
            <td>Cell 29</td>
            <td>Cell 30</td>
          </tr>
          <tr>
            <td>Cell 31</td>
            <td>Cell 32</td>
            <td>Cell 33</td>
            <td>Cell 34</td>
            <td>Cell 35</td>
          </tr>
          <tr>
            <td>Cell 36</td>
            <td>Cell 37</td>
            <td>Cell 38</td>
            <td>Cell 39</td>
            <td>Cell 40</td>
          </tr>
          <tr>
            <td>Cell 41</td>
            <td>Cell 42</td>
            <td>Cell 43</td>
            <td>Cell 44</td>
            <td>Cell 45</td>
          </tr>
	<tr>
            <td>Cell 46</td>
            <td>Cell 47</td>
            <td>Cell 48</td>
            <td>Cell 49</td>
            <td>Cell 45</td>
          </tr>
<tr>
            <td colspan="5"></td>
          </tr>
        </tbody>
</table>
 <button class="back-button">뒤로가기</button>
    </div>
  </body>
</html>