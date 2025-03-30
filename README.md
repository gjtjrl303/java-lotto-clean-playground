# 로또 게임

# 프로젝트 개요
- 로또 번호를 발급해주는 프로그램

## 기능
- 한장당 번호는 1 ~ 45까지 6개의 숫자를 발급한다.
- 로또 1장은 1000원이다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또마다 몇개의 번호를 맞췄는지 계산해준다.
- 비용에대한 수익률을 계산해준다.

## 사용방법
- 돈을 입력한다.
- 당첨 번호를 입력한다.
- 로또별로 몇개의 번호를 맞췄는지 확인하다.
- 수익률을 확인한다.

---

## 로또 도메인 역할 & 책임
### 1. LottoNumber
- 역할 
  - 로또 번호 하나를 표현하는 객체 
- 책임
  - 번호가 1 ~ 45 사이인지 검증
  - 동일 값인지 비교 (equals & hashCode)
  - toString 으로 출력 포맷 제공
---
### 2. Lotto 
- 역할
  - 하나의 로또 티켓(6개의 숫자)을 표현하는 객체
- 책임
  - 6개의 숫자를 가지는지 검증
  - 정적 리스트를 Lotto로 변환하는 정적 팩토리 메서드 제공
---
### 3. LottoGenerator
- 역할
  - 로또의 숫자를 6개씩 담아 반환
- 책임
  - 1 ~ 45까지의 숫자를 섞은 후 앞의 6개의 숫자를 List<Integer>에 담아서 제공
---
### 4. LottoRepository
-  역할
  - 발급한 로또 객체들을 저장하는 저장소
- 책임
  - 저장소에 로또 객체 하나를 저장
  - 저장소의 로또를 리스트에 담아 반환
---
### 5. Money
- 역할 
  - 구입한 금액을 담은 객체
- 책임
  - 사용자가 구입한 가격이 1000원 이상인지 검증
  - 사용자가 로또 하나의 가격에 맞춰 냈는지 검증
  - 가격에 맞는 로또의 객수를 반환
---
### 6. PrizeMoney
- 역할
  - 로또의 상금 금액을 저장하는 객체
- 책임
  - 상금이 0 이상인지 검증
  - 상금을 곱하는 메서드 제공
  - 상금을 더하는 메서드 제공
---
### 7. LottoWinningNumbers
- 역할
  - 지난 주 당첨 번호 관리 
- 책임
  - 로또를 매개변수로 받아 일치하는 수의 개수를 반환하는 메서드 제공 
---
### 8. LottoResult
 - 역할
   - 구매한 로또의 결과를 저장하는 객체
 - 책임
   - 3,4,5,6개를 맞춘 각각의 로또의 개수를 저장
   - 구매한 가격
---
### 9. LottoMachine
- 역할
  - 로또 생성 및 관리
- 책임
  - 금액 입력 받고 로또 생성
  - 생생된 로또 리스트 반환
---
### 10. LottoShop
- 역할
  - 도메인 객체들의 비즈니스 흐름 조율
- 책임
  - 비즈니스 흐름 제어
  - LottoResult 반환
---
### 11. LottoView
- 역할
  - 입출력 처리

---
# 도메인과 서비스
### LottoShop의 메서드 정리
- inputWinningNumbers()
  - 지난 주 당첨 번호를 입력받아 저장을 한다.
- inputMoney()
  - 사용자로 부터 금액을 받는다
- generateLottos()
  - 로또 번호를 생성한다
- getPurchasedLottos()
  - 구매한 로또 번호를 반환한다
- getResultByRank()
  - 당첨 번호와 구매한 로또 목록을 비교하여 등수별로 몇 개 맞췄는지 결과를 반환합니다.
- getProfitRate()
  - 구매한 로또들의 총 수익률을 계산하여 반환합니다.
- getLottoCount()
  - 구매한 로또 개수를 반환한다.

## - 정리
- LottoShop은 로또 구매, 당첨 번호 등록, 당첨 결과 계산, 수익률 계산 등
모두 현실 세계에서의 의사결정 흐름을 표현하고 있습니다.
따라서 LottoShop은 도메인 로직을 담당하는 객체라고 볼 수 있습니다.
