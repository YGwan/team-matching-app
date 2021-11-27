# TeamMatching_App

## kotlin + firebase로 팀매칭 앱 구현

###   로그인화면 UI
<https://user-images.githubusercontent.com/50222603/143711501-c6706058-7442-4371-8584-f8e142b56a10.mov>

  * 실제로 로그인되는 과정.  
  (https://github.com/YGwan/TeamMatching_App/files/7612244/join.zip)

  * Intent로 페이지를 넘기고 data를 주고 받음
  * firebase와 연동해 회원가입 및 로그인 구현



###   메인화면 UI

https://user-images.githubusercontent.com/50222603/143717573-774b679d-8401-469c-bd5e-638b507f45ff.mov

  * 실제로 메인화면 실행 과정.  (https://github.com/YGwan/TeamMatching_App/files/7612277/mainPage.zip)
  * fragment로 화면을 넘기고 navigation으로 필요부분만 연결시킴
  * firebase로 로그아웃 구현하고 (ui, email) 값 가져와서 출력함
 



### 팀화면 UI

https://user-images.githubusercontent.com/50222603/143717544-61ccd484-6434-4c00-8468-78858c573d05.mov

 * 실제로 팀화면 실행 과정.      
(https://github.com/YGwan/TeamMatching_App/files/7612263/Team.zip)
 * Intent로 페이지를 넘기고 data를 주고 받음
 * 파이어베이스에서 팀 이름, 주제, 리더명, 현재 날짜를 저장하고 출력함 



### 게시판화면 UI

<https://user-images.githubusercontent.com/50222603/143717606-88c8167e-127b-4da9-95de-2e4d2c291b37.mov>

  * 실제로 게시판화면 실행 과정.   
  (https://github.com/YGwan/TeamMatching_App/files/7612262/board.zip)
  * Intent로 페이지를 넘기고 data를 주고 받음
  * firebase에 게시판, 댓글 관련된 값을 입력하고 가져와서 출력, uid값을 비교해서 본인이면 삭제, 레이아웃색 변경 등을 구현


### firebase 데이터 처리
 * Authentication
  
  <img width="953" alt="Authentication" src="https://user-images.githubusercontent.com/50222603/143719318-0b022ae0-cc26-4a29-b4cf-86f6bd69f8d7.png">
  
  * Realtime Data
     * 팀게시판 -> board
     * 댓글 -> comment
     * 팀 -> team


  <img width="1082" alt="스크린샷 2021-11-28 오전 4 12 25" src="https://user-images.githubusercontent.com/50222603/143719319-f790d5c1-ec28-4703-9b12-0e00887c103a.png">
  




