# 🎓 Smart Campus

### Low-Cost High-Efficiency Barrier-Free Kiosk for University Information Services

> 2023 Capstone Design Project
> Department of Computer Software Engineering, Dongyang Mirae University
> Team The November

---

# 📖 Introduction

Smart Campus는 대학 구성원들이 학교 생활에 필요한 정보를 쉽고 빠르게 얻을 수 있도록 개발된 통합 정보 제공 키오스크 시스템이다.

코로나19 이후 증가한 비대면 환경과 복잡한 캠퍼스 정보 접근 문제를 해결하기 위해 개발되었으며, 신입생, 복학생, 교직원, 방문객 등 다양한 사용자를 대상으로 한다.

특히 기존 키오스크의 한계로 지적되는 접근성 문제를 개선하기 위해 음성 인식, 음성 안내, 높이 조절 기능을 적용한 배리어 프리(Barrier-Free) 키오스크를 구현하였다.

---

# 🎯 Project Objectives

* 대학 구성원의 정보 접근성 향상
* 스마트 캠퍼스 환경 구축
* 디지털 취약계층 접근성 개선
* 음성 기반 사용자 인터페이스 제공
* 학교 정보 통합 플랫폼 구축
* 저비용 고효율 키오스크 시스템 개발

---

# 🚀 Key Features

## 🔐 User Authentication

* 회원가입
* 로그인
* 회원정보 수정
* 사용자 인증 관리

## 📢 Notice Service

* 공지사항 조회
* 공지사항 검색
* 조회수 기능
* 중요 공지 상단 고정(Pinned)

## 📅 Academic Schedule

* 학사일정 조회
* 기간별 일정 관리
* 학기별 주요 일정 확인

## 🕒 Timetable Management

* 시간표 등록
* 시간표 수정
* 강의실 정보 확인
* 학생별 시간표 관리

## 👨‍🏫 Staff Information

* 교직원 정보 조회
* 부서별 검색
* 담당 업무 조회
* 연락처 조회

## 🎓 Club Information

### Major Clubs

* 전공 동아리 소개
* 프로젝트 정보 제공
* 지도교수 정보 조회

### Hobby Clubs

* 취미 동아리 소개
* 활동 정보 조회

## 🔍 Lost & Found

* 분실물 신고
* 습득물 신고
* 게시글 조회
* 익명 등록 지원

## 📝 Communication Board

* 학교에 바란다 게시판
* 건의사항 등록
* 관리자 답변 기능
* 진행 상태 확인

## 🗺 Campus Navigation

* 카카오맵 기반 위치 서비스
* 캠퍼스 지도
* 길찾기 기능
* 건물 위치 안내

## 🚇 Real-Time Transportation

* 실시간 지하철 정보 조회
* 자동 새로고침 기능
* 공공데이터 API 활용
* 실시간 위치 정보 제공

## 🎤 Voice Search

Google Cloud Speech-To-Text 기반 음성 검색

* 음성 명령 인식
* 검색어 자동 변환
* 키보드 입력 없이 검색 가능

## 🔊 Voice Guide

Google Cloud Text-To-Speech 기반 음성 안내

* 기능 설명 제공
* 음성 피드백 제공
* 사용자 편의성 향상

## ♿ Barrier-Free Accessibility

* Linear Actuator 기반 높이 조절
* Arduino 제어
* 장애인 접근성 개선
* 디지털 취약계층 지원

---

# 🏗 System Architecture

```text
User
 │
 ▼
Java Swing Kiosk Application
 │
 ├── MySQL Database (AWS RDS)
 │
 ├── Flask Server
 │
 ├── Google Cloud STT/TTS
 │
 ├── Kakao Map API
 │
 ├── Public Transportation API
 │
 └── Raspberry Pi + Arduino
```

---

# ⚙️ Technologies

## Front-End

* Java Swing
* JavaFX
* HTML
* CSS

## Back-End

* Java
* Python
* Flask

## Database

* MySQL
* AWS RDS

## Cloud Services

* Google Cloud Speech-To-Text
* Google Cloud Text-To-Speech

## Open APIs

* Kakao Map API
* Public Transportation API

## Hardware

* Raspberry Pi 4
* Arduino Uno
* Linear Actuator
* Fingerprint Sensor

## Development Environment

* Eclipse
* IntelliJ IDEA
* Spring Tool Suite 4
* Arduino IDE
* Visual Studio Code
* MySQL Workbench
* Git

---

# 🗄 Database Design

본 시스템은 MySQL 기반 RDBMS 구조로 설계되었다.

### Main Tables

| Table               | Description |
| ------------------- | ----------- |
| user1               | 사용자 정보      |
| timetable           | 시간표         |
| notices             | 공지사항        |
| staff               | 교직원 정보      |
| majorclubs          | 전공 동아리      |
| hobbyclubs          | 취미 동아리      |
| found_items         | 습득물 신고      |
| lost_items          | 분실물 신고      |
| communication_board | 학교에 바란다     |
| academic_schedule   | 학사일정        |

---

# 🔄 System Workflow

1. 사용자가 키오스크 접속
2. Java Swing GUI를 통해 기능 선택
3. 서버 및 데이터베이스 요청 수행
4. API 또는 DB 데이터 수신
5. 결과 화면 출력
6. 필요 시 음성 안내 제공
7. 사용자와 지속적인 상호작용 수행

---

# 👨‍💻 My Contributions

### Hardware Integration

* Arduino 기반 액추에이터 제어
* Raspberry Pi 연동
* 센서 인터페이스 구현
* 하드웨어 테스트 및 검증

### Voice Interface

* Google Cloud STT 구현
* Google Cloud TTS 구현
* 음성 검색 기능 개발
* 음성 안내 기능 개발

### Software Development

* Java Swing GUI 구현
* Flask 페이지 연동
* 실시간 대중교통 조회 기능 구현
* 시스템 통합 테스트

### Project Support

* 기능 통합
* 오류 수정
* 발표 자료 제작
* 시연 영상 제작

---

# 📈 Expected Effects

* 학교 정보 접근성 향상
* 사용자 경험(UX) 개선
* 장애인 접근성 향상
* 실시간 정보 제공
* 스마트 캠퍼스 환경 구축
* 저비용 고효율 키오스크 플랫폼 제공

---

# 📚 Research Basis

본 프로젝트는 「저비용 고효율 배리어프리 키오스크」 졸업논문을 기반으로 개발되었다.

핵심 연구 분야

* Barrier-Free Kiosk
* Java Swing GUI
* Raspberry Pi & Arduino IoT
* Google Cloud STT/TTS
* Real-Time Transportation Information
* Kakao Map API
* AWS RDS
* MySQL Database Design

---

# 👥 Team The November

| Name | Role                                                                   |
| ---- | ---------------------------------------------------------------------- |
| 이동규  | System & Hardware                                                      |
| 김기석  | System & Database                                                      |
| 강종민  | Design, Hardware Integration, Google Cloud API, Java Swing Development |

---

# ⚠️ Archive Notice

본 저장소는 2023년 졸업작품 아카이브 목적으로 공개되었습니다.

프로젝트 복구 과정에서 일부 라이브러리, 인증키, 데이터베이스 백업 파일이 유실되어 원본 환경 그대로 실행되지 않을 수 있습니다.

그러나 시스템 설계, 데이터베이스 구조, 주요 기능 구현 및 소스코드는 확인 가능합니다.
