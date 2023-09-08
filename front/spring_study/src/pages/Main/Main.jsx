import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { deleteUser, getUserListAll, registerUser, updateUser } from '../../api/users';

function Main(props) {
    // 초기 빈 사용자 정보 객체
    const emptyUser = {
        userId: "",
        username: "",
        name: "",
        phone: ""
    };

     // 사용자 입력 상태와 사용자 목록 상태를 관리하는 상태 변수 선언
    const [ userInput, setUserInput ] = useState(emptyUser);
    const [ userList, setUserList ] = useState([]);

    // 현재 모드를 관리하는 상태 변수 선언 (0: 기본 모드, 1: 등록 모드, 2: 수정 모드)
    const [ mode, setMode ] = useState(0);

     // 서버에서 사용자 목록을 가져오는 함수
    const requestGetUserListAll = () => {
        getUserListAll()
        .then(response => {
            console.log(response);
            setUserList(response.data); // 서버 응답으로 받은 사용자 목록을 상태에 업데이트
            setUserInput(emptyUser); // 사용자 입력 상태를 초기화 (등록 후),  등록하고 나서 비워줌
        })
    }

    // 컴포넌트가 처음 렌더링될 때 사용자 목록을 가져오기 위한 useEffect
    useEffect(() => { 
        requestGetUserListAll();
    }, [])

     // 사용자 입력 필드 값이 변경될 때 호출되는 함수
    const handleUserInputChange = (e) => {
        setUserInput({
            ...userInput, // ... 전의 원래 내용을 가지고 옴
            [e.target.name]: e.target.value // name의 value 를 가져와서 덮어줌
        });
    }

    // 등록 버튼을 클릭했을 때 호출되는 함수
    const handleRegisterClick = () => {
        // 모드를 등록 모드로 변경하고 사용자 입력 상태를 초기화
        setMode(1);
        setUserInput(emptyUser);
    }

     // 등록 확인 버튼을 클릭했을 때 호출되는 함수
    const handleRegisterSubmitClick = async () => {
        await registerUser(userInput); // 사용자 등록 요청을 서버에 보내고 기다림
        requestGetUserListAll();  // 사용자 목록을 다시 가져오는 함수 호출

        // 동기로 동작 할 수 있게끔 await을 써준다.
        
    }

    // 수정 버튼을 클릭했을 때 호출되는 함수
    const handleUpdateClick = async () => {
        await updateUser(userInput);  // 사용자 정보 업데이트 요청을 서버에 보내고 기다림
        requestGetUserListAll(); 
    }

    // 삭제 버튼을 클릭했을 때 호출되는 함수
    const handleDeleteClick = async () => {
        await deleteUser(userInput.userId);
        requestGetUserListAll();
    }

    // 사용자를 선택했을 때 호출되는 함수
    const handleSelectClick = (user) => {
        // 모드를 수정 모드로 변경하고 선택한 사용자 정보로 사용자 입력 상태를 업데이트
        setMode(2);
        setUserInput(user);
    }

    return (
        <div>
            <div>
                <input type="text" name='userId' placeholder='user-id' 
                onChange={handleUserInputChange} 
                value={userInput.userId}
                disabled/> {/* userInput 상태인 상태이다.  */}
            </div>

            <div>
                <input type="text" name='username' placeholder='username' 
                onChange={handleUserInputChange} 
                value={userInput.username}
                disabled={mode === 0}/>
            </div>

            <div>
                <input type="text" name='name' placeholder='name' 
                onChange={handleUserInputChange} 
                value={userInput.name}
                disabled={mode === 0}/>
            </div>

            <div>
                <input type="text" name='phone' placeholder='phone' 
                onChange={handleUserInputChange} 
                value={userInput.phone}
                disabled={mode === 0}/>
            </div>
            {mode === 1 
            ? <button onClick={handleRegisterSubmitClick}>확인</button> 
            : <button onClick={handleRegisterClick}>등록하기</button>}
            
            <button onClick={handleUpdateClick} disabled={mode !== 2}>수정하기</button>
            <button onClick={handleDeleteClick} disabled={mode !== 2}>삭제하기</button>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>사용자명</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th>선택</th>
                        </tr>
                    </thead>
                    <tbody>
                        {userList.map(user => 
                                <tr key={user?.userId}>
                                    <td>{user?.userId}</td>
                                    <td>{user?.username}</td>
                                    <td>{user?.name}</td>
                                    <td>{user?.phone}</td>
                                    <td><button onClick={() => {handleSelectClick(user);}}>✔️</button></td> {/* {handleSelectClick(user);}} 함수를 정의해서 매개변수를 정해준다 */}
                                    
                                </tr>
                            )}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Main;