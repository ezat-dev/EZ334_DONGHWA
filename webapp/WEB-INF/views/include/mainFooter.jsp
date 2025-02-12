<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer UI</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            padding-bottom: 100px;
        }

        .footer {
            display: flex;
            background-color: #123478;
            color: white;
            padding: 10px;
            padding-left: 230px;
            align-items: center;
            font-size: 18px;
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 120px;
            justify-content: space-around;
            gap: 20px;
        }

        .footer .section {
            padding: 10px;
            flex: 1;
        }

        .footer p {
            margin: 5px 0;
        }

        .footer .buttons {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            justify-content: center;
            align-items: center;
        }

        .button {
            width: 88px;
            height: 88px;
            background-color: #5a738e;
            border-radius: 15px;
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
        }

        .button img {
            width: 40px;
            height: 40px;
        }

        .tabulator {
            width: 100%;
            max-width: 500px;
            height: 100px;
            border-collapse: collapse;
            background-color: #f0f0f0;
            color: black;
            font-weight: bold;
            border-radius: 8px;
            overflow-y: scroll;
            margin: 0 auto;
            margin-left: 70px;
        }

        .tabulator td, .tabulator th {
            text-align: center;
            border: 1px solid #ccc;
            padding: 10px;
        }

        .tabulator th {
            background-color: #808080 !important;
        }

        .tabulator td {
            background-color: #666666 !important;
            text-align: left;
        }

        .tabulator td.eventText {
            width: 80%;
        }

        .tabulator td.status {
            width: 20%;
        }

        .dynamic-value {
            color: gray;
        }

        .dynamic-value.null {
            color: gray;
        }

        .section {
            margin-left: 50px;
            height: 100px;
            margin-bottom: 5px;
        }

        .section status {
            margin-left: 70px;
        }
        
    .button-container {
	  position: absolute;
	  left: 21px;
	  top: 66px;
	  display: flex; /* 버튼을 가로로 정렬 */
	  gap: 10px; /* 버튼 간격 */
	}
	
	.button {
	  width: 84px;
	  height: 84px;
	  border-radius: 20px;
	  background-color: #5A6D8A; /* 연한 남색 */
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  cursor: pointer;
	  transition: background-color 0.3s ease, transform 0.2s ease;
	}
	
	.button img {
	  width: 53px;
	  height: 53px;
	  object-fit: contain;
	}
	
	.button:hover {
	  background-color: #4C5C77; /* 호버 시 색상 변경 */
	  transform: scale(1.05);
	}
	
	.button:active {
	  background-color: #3A4A66;
	  transform: scale(0.95);
	}
    </style>
</head>
<body>

<div class="footer">
    <div class="section">
        <p><strong>Program Number:</strong> <span class="programNumber">NULL</span></p>
        <p><strong>Program Name:</strong> <span class="programName">NULL</span></p>
        <p><strong>Program Comment:</strong> <span class="programComment">NULL</span></p>
    </div>
    <div class="section">
        <p><strong>Segment number:</strong> <span class="segmentNumber">NULL</span></p>
        <p><strong>Seg. remaining time:</strong> <span class="segRemainingTime">NULL</span></p>
        <p><strong>Prg. remaining time:</strong> <span class="prgRemainingTime">NULL</span></p>
    </div>
    <div class="buttons">
        <div class="button"><img src="/donghwa/css/furnace/img/pause3.png" alt="Stop"></div>
        <div class="button"><img src="/donghwa/css/furnace/img/fire3.png" alt="Warning"></div>
        <div class="button"><img src="/donghwa/css/furnace/img/man3.png" alt="Alarm"></div>
        <div class="button"><img src="/donghwa/css/furnace/img/death3.png" alt="Info"></div>
        <div class="button"><img src="/donghwa/css/furnace/img/sound3.png" alt="no_sound"></div>
        <div class="button"><img src="/donghwa/css/furnace/img/siren3.png" alt="alarm"></div>
    </div>

    <table class="tabulator">
        <thead>
            <tr>
                <th>Event Text</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="eventText">ALARM DATA EX1</td>
                <td class="status">Y</td>
            </tr>
            <tr>
                <td class="eventText">ALARM DATA EX2</td>
                <td class="status">Y</td>
            </tr>
        </tbody>
    </table>

    <div class="section status">
        <p><strong>Status 1:</strong> <span class="status1">NULL</span></p>
        <p><strong>Status 2:</strong> <span class="status2">NULL</span></p>
        <p><strong>Status 3:</strong> <span class="status3">NULL</span></p>
    </div>
</div>

<script>
    function updateValues(data) {
        document.querySelectorAll('.dynamic-value').forEach(el => {
            const key = el.getAttribute('data-key');
            if (data[key]) {
                el.textContent = data[key];
                el.classList.remove('null');
            } else {
                el.textContent = "NULL";
                el.classList.add('null');
            }
        });
    }
</script>

</body>
</html>
