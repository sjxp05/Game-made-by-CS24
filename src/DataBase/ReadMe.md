android Room database (SQLite 문법을 따릅니다 ..) - Android Studio ide 사용을 추천합니다
<br>build.gradle(Module : app) 에 의존성 추가 필수(함께 업로드햇읍니다~ 복사붙여넣기 해보고 안되면 연락해주세요.... )

### app/src/main/java/irumaeDB 패키지
1. entity : Irumae 파일(데이터의 기본 필드, 메서드 저장)
   -필드 종류-
   <br>primary key: int id(자동부여)
   <br>String rumaeName, playerName
   <br>Major major // Major.enum 에 가능학과 지정, 지정된 학과만 데이터에 입력 가능
   <br>int intelligence, energe, stress

2. DAO : DaoIrumae 파일
   메인에서 데이터베이스를 수정, 관리할 수 있는 메서드(메인에서 직접 데이터베이스에 접근하지 않고 DAO 파일을 거쳐 안정성 확보)
   <br>-현재 입력되어 있는 메서드-
   <br>insert(데이터 생성) update(데이터 수정) delete(데이터 삭제)
   <br>getById(id 필드 기준으로 데이터 하나만 검색)
   <br>getAll(id 필드 기준 정렬로 모든 데이터 가져오기)

3. database : DBIrumae 파일
   데이터베이스 생성하는 클래스(임의 수정 X)
   <br>entity 필드 추가 등 데이터 구조 변경 있을 때만 version 올려주면 됨

4. Converters
   <br>String 으로 정의되는 학과이름을 Major타입으로 바꾸어주는 클래스


### app/src/main/java/com/example/growirumae/MainActivity.java
여기서 각 파일의 메서드를 불러와서 데이터베이스 생성, 데이터 수정, 삽입, 삭제 등을 진행
<br>데이터베이스 인스턴스[이름: db]와 관리를 위한 dao객체[이름: daoIrumae]를 생성하는 로직은 작성해놓음(임의 수정 X)
<br>현재 개발 단계라서 메인스레드에서 직접 데이터베이스에 접근하고 있는데, 추후 수정

사용방법(insert 기준)
1. 입력하고자 하는 Irumae 객체를 하나 찍어낸다 (예: irumae1이라고 하자)
2. irumae1.setter 써서 entity 필드 설정
3. daoIrumae.insert(irumae1); 해서 삽입
