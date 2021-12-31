# programmers_신규 아이디 추천
import re

def solution(new_id):
    answer = ''

    # 소문자 치환
    answer = re.sub('[^a-z\d\-\_\.]', '', new_id.lower())

    # 마침표  하나로
    answer = re.sub('\.\.+', '.', answer)

    # 양 끝 마침표 제거
    answer = re.sub('^\.|\.$', '', answer)

    # 빈 문자열 - a 대입
    if answer == '':
        answer = 'a'

    # 길이가 16자 이상이면 1~15자만 남기기 & 맨 끝 마침표 제거
    answer = re.sub('\.$', '', answer[0:15])
    
    # 길이가 3이 될 때까지 반복해서 끝에 붙이기
    while len(answer) < 3:
        answer += answer[-1:]
    return answer