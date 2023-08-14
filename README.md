# 랜덤 이미지 생성
원하는 패턴의 클래스 생성한 후 make()
### 클래스 목록
- Bomb
- HorizontalStripe
- FineHorizontalStripe
- VerticalStripe
- FineVerticalStripe
- DiagonalStripe
- FineDiagonalStripe
### 예시 코드
RandImgGenerator.java
- 저장 위치 수정: save()
- 이미지 크기 수정: field의 width, height
## Bomb 생성자
- 최대 색 차이(int)
- 확장 확률(double)
- 개수 설정할 때 나누는 수(int)
## Stripe, Fine Stripe 생성자
최대 색 차이(int)

방향
- 가로(Horizontal)
- 세로(Vertical)
- 대각선(Diagonal)
# 결과
<div style='display: flex;'>
    <img src='img/bomb10_48_64.png' style='margin: 10px'>
    <img src='img/bomb14_60_500.png' style='margin: 10px'>
</div>
<div style='display: flex;'>
    <img src='img/finehorizontalstripe10.png' style='margin: 10px'>
    <img src='img/horizontalstripe10.png' style='margin: 10px'>
</div>
<div style='display: flex;'>
    <img src='img/fineverticalstripe10.png' style='margin: 10px'>
    <img src='img/verticalstripe10.png' style='margin: 10px'>
</div>
<div style='display: flex;'>
    <img src='img/finediagonalstripe10.png' style='margin: 10px'>
    <img src='img/diagonalstripe20.png' style='margin: 10px'>
</div>