# 🎓 Smart Campus

> **Low-Cost High-Efficiency Barrier-Free Kiosk for University Information Services**

**2023 Capstone Design Project** · Department of Computer Software Engineering, Dongyang Mirae University · **Team The November**

![Java](https://img.shields.io/badge/Java-Swing-007396?logo=openjdk&logoColor=white)
![Python](https://img.shields.io/badge/Python-Flask-3776AB?logo=python&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-AWS_RDS-4479A1?logo=mysql&logoColor=white)
![Google Cloud](https://img.shields.io/badge/Google_Cloud-STT%2FTTS-4285F4?logo=googlecloud&logoColor=white)
![Raspberry Pi](https://img.shields.io/badge/Raspberry_Pi-4-A22846?logo=raspberrypi&logoColor=white)
![Arduino](https://img.shields.io/badge/Arduino-Uno-00979D?logo=arduino&logoColor=white)

> ⚠️ **Archive Notice**
> 본 저장소는 **2023년 졸업작품 아카이브** 목적으로 공개되었습니다.
> 프로젝트 복구 과정에서 일부 라이브러리, 인증키, 데이터베이스 백업 파일이 유실되어
> 원본 환경 그대로 실행되지 않을 수 있습니다. 그러나 시스템 설계, 데이터베이스 구조,
> 주요 기능 구현 및 소스코드는 확인 가능합니다.

## 📖 Introduction

**Smart Campus**는 대학 구성원들이 학교 생활에 필요한 정보를 쉽고 빠르게 얻을 수 있도록
개발된 통합 정보 제공 키오스크 시스템입니다.

코로나19 이후 증가한 비대면 환경과 복잡한 캠퍼스 정보 접근 문제를 해결하기 위해
개발되었으며, 신입생·복학생·교직원·방문객 등 다양한 사용자를 대상으로 합니다.

특히 기존 키오스크의 한계로 지적되는 접근성 문제를 개선하기 위해 **음성 인식**,
**음성 안내**, **높이 조절** 기능을 적용한 **배리어 프리(Barrier-Free) 키오스크**를
구현했습니다.

## 🎯 Project Objectives

- 대학 구성원의 정보 접근성 향상
- 스마트 캠퍼스 환경 구축
- 디지털 취약계층 접근성 개선
- 음성 기반 사용자 인터페이스 제공
- 학교 정보 통합 플랫폼 구축
- 저비용 고효율 키오스크 시스템 개발

## 🚀 Key Features

### 정보 서비스

| 기능 | 설명 |
|------|------|
| 🔐 **User Authentication** | 회원가입 · 로그인 · 회원정보 수정 · 사용자 인증 관리 |
| 📢 **Notice Service** | 공지사항 조회·검색, 조회수 기능, 중요 공지 상단 고정(Pinned) |
| 📅 **Academic Schedule** | 학사일정 조회, 기간별 일정 관리, 학기별 주요 일정 확인 |
| 🕒 **Timetable Management** | 시간표 등록·수정, 강의실 정보 확인, 학생별 시간표 관리 |
| 👨‍🏫 **Staff Information** | 교직원 정보 조회, 부서별 검색, 담당 업무·연락처 조회 |
| 🎓 **Club Information** | 전공 동아리(프로젝트·지도교수 정보) 및 취미 동아리 소개 |
| 🔍 **Lost & Found** | 분실물·습득물 신고, 게시글 조회, 익명 등록 지원 |
| 📝 **Communication Board** | '학교에 바란다' 건의 게시판, 관리자 답변, 진행 상태 확인 |

### 실시간 · 위치 서비스

| 기능 | 설명 |
|------|------|
| 🗺 **Campus Navigation** | 카카오맵 기반 캠퍼스 지도, 길찾기, 건물 위치 안내 |
| 🚇 **Real-Time Transportation** | 공공데이터 API 기반 실시간 지하철 정보 조회, 자동 새로고침 |

### 배리어 프리 (Barrier-Free)

| 기능 | 설명 |
|------|------|
| 🎤 **Voice Search** | Google Cloud STT 기반 음성 검색 — 키보드 입력 없이 음성 명령으로 검색 |
| 🔊 **Voice Guide** | Google Cloud TTS 기반 음성 안내 — 기능 설명 및 음성 피드백 제공 |
| ♿ **Height Adjustment** | Arduino 제어 Linear Actuator 기반 높이 조절 — 휠체어 사용자 등 접근성 개선 |

## 🏗 System Architecture

```
User
 │
 ▼
Java Swing Kiosk Application
 │
 ├── MySQL Database (AWS RDS)
 ├── Flask Server
 ├── Google Cloud STT / TTS
 ├── Kakao Map API
 ├── Public Transportation API
 └── Raspberry Pi + Arduino (Linear Actuator, Fingerprint Sensor)
```

## ⚙️ Technologies

| 분류 | 기술 |
|------|------|
| **Front-End** | Java Swing, JavaFX, HTML, CSS |
| **Back-End** | Java, Python, Flask |
| **Database** | MySQL, AWS RDS |
| **Cloud Services** | Google Cloud Speech-To-Text, Google Cloud Text-To-Speech |
| **Open APIs** | Kakao Map API, Public Transportation API |
| **Hardware** | Raspberry Pi 4, Arduino Uno, Linear Actuator, Fingerprint Sensor |
| **Dev Environment** | Eclipse, IntelliJ IDEA, Spring Tool Suite 4, Arduino IDE, VS Code, MySQL Workbench, Git |

## 🗄 Database Design

MySQL 기반 RDBMS 구조로 설계되었습니다.

| Table | Description |
|-------|-------------|
| `user1` | 사용자 정보 |
| `timetable` | 시간표 |
| `notices` | 공지사항 |
| `staff` | 교직원 정보 |
| `majorclubs` | 전공 동아리 |
| `hobbyclubs` | 취미 동아리 |
| `found_items` | 습득물 신고 |
| `lost_items` | 분실물 신고 |
| `communication_board` | 학교에 바란다 |
| `academic_schedule` | 학사일정 |

## 🔄 System Workflow

1. 사용자가 키오스크 접속
2. Java Swing GUI를 통해 기능 선택
3. 서버 및 데이터베이스 요청 수행
4. API 또는 DB 데이터 수신
5. 결과 화면 출력
6. 필요 시 음성 안내 제공
7. 사용자와 지속적인 상호작용 수행

## 👨‍💻 My Contributions

**Hardware Integration**
- Arduino 기반 액추에이터 제어, Raspberry Pi 연동
- 센서 인터페이스 구현, 하드웨어 테스트 및 검증

**Voice Interface**
- Google Cloud STT/TTS 구현
- 음성 검색 및 음성 안내 기능 개발

**Software Development**
- Java Swing GUI 구현, Flask 페이지 연동
- 실시간 대중교통 조회 기능 구현, 시스템 통합 테스트

**Project Support**
- 기능 통합 및 오류 수정, 발표 자료·시연 영상 제작

## 📈 Expected Effects

- 학교 정보 접근성 향상 및 사용자 경험(UX) 개선
- 장애인·디지털 취약계층 접근성 향상
- 실시간 정보 제공을 통한 스마트 캠퍼스 환경 구축
- 저비용 고효율 키오스크 플랫폼 제공

## 📚 Research Basis

본 프로젝트는 졸업논문 **「저비용 고효율 배리어프리 키오스크」**를 기반으로 개발되었습니다.

**핵심 연구 분야**: Barrier-Free Kiosk · Java Swing GUI · Raspberry Pi & Arduino IoT ·
Google Cloud STT/TTS · Real-Time Transportation Information · Kakao Map API ·
AWS RDS · MySQL Database Design

## 👥 Team The November

| Name | Role |
|------|------|
| 이동규 | System & Hardware |
| 김기석 | System & Database |
| **강종민** | Design, Hardware Integration, Google Cloud API, Java Swing Development |
