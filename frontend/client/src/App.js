import 'antd/dist/antd.css';
import { BrowserRouter, Redirect, Route } from 'react-router-dom';
import './App.css';
import AddCar from './pages/AddCar';
import AdminHome from './pages/AdminHome';
import BookingCar from './pages/BookingCar';
import EditCar from './pages/EditCar';
import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register';
import UserBookings from './pages/UserBookings';

function App() {
  return (
    <div className="App">

         
         
         <BrowserRouter>
             
             <ProtectedRoute path='/' exact component={Home} />
             <Route path='/login' exact component={Login} />
             <Route path='/register' exact component={Register} />
             <ProtectedRoute path='/booking/:carid' exact component={BookingCar} />
             <ProtectedRoute path='/userbookings' exact component={UserBookings} />
             <ProtectedRoute path='/addcar' exact component={AddCar} />
             <ProtectedRoute path='/editcar/:carid' exact component={EditCar} />
             <ProtectedRoute path='/admin' exact component={AdminHome} />
         
         </BrowserRouter>

    </div>
  );
}



export default App;


export function ProtectedRoute(props)
{


    if(localStorage.getItem('user'))
    {
      return <Route {...props}/>
    }
    else{
      return <Redirect to='/login'/>
    }

}
