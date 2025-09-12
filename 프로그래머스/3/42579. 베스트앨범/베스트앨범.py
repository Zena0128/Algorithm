def solution(genres, plays):
    info = dict()
    n = len(genres)
    for i in range(n):
        if genres[i] not in info.keys():
            info[genres[i]] = [(i, plays[i])]
        else:
            info[genres[i]].append((i, plays[i]))
    answer = []

    # 재생수 합이 높은 장르부터 정렬
    sum_plays = [[genre, sum(song[1] for song in info[genre])] for genre in info.keys()]
    sum_plays.sort(key=lambda x:-x[1])
    
    # 장르 내에서 재생수가 높은 노래->고유 번호가 낮은 노래부터 정렬
    for genre in info.keys():
        info[genre].sort(key=lambda plays: (-plays[1], plays[0]))
    
    # 장르별로 가장 많이 재생된 최대 두 개의 곡 수록
    for genre, plays in sum_plays:
        for i in range(min(2, len(info[genre]))):
            answer.append(info[genre][i][0])
    return answer