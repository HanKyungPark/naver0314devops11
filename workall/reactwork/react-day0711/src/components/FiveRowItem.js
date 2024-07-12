const FiveRowItem = ({ mycar }) => {
    const storage = "https://kr.object.ncloudstorage.com/hankyung133/mycar/";
    return (
        <>
            <tr>
                <td style={{width: '200px'}} align="center" rowSpan={4}>
                    <img alt="" style={{width: '180px', height: '180px'}}
                         src={`${storage}${mycar.carphoto}`} />
                </td>
                <td>자동차명 : {mycar.carname}</td>
            </tr>
            <tr>
                <td>가격 : {mycar.carprice}</td>
            </tr>
            <tr>
                <td style={{backgroundColor:`${mycar.carcolor}`}}>{mycar.carcolor}</td>
            </tr>
            <tr>
                <td>{mycar.carguip}</td>
            </tr>
            
        </>
    );
}

export default FiveRowItem;
