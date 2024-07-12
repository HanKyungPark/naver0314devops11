import Content from './Content';
import Header from './Header';
import Footer from './Footer';
import './context.css'
const Page=()=>{
    return(
        <div className='page'>
            <Header/>
            <Content/>
            <Footer/>
        </div>
    )
}
export default Page;