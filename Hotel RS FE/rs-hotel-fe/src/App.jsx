import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import ExistingRooms from './components/room/ExistingRooms'
import EditRoom from './components/room/EditRoom'
import Home from './components/home/Home'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import AddRoom from './components/room/AddRoom'
import Navbar from './components/layout/Navbar'
import Footer from './components/layout/Footer'
import RoomListing from './components/room/RoomListing'
import Admin from './components/admin/Admin'
import Checkout from './components/bookings/Checkout'
import BookingSuccess from './components/bookings/BookingSuccess'

function App() {

  return <>

  <main>
    <Router>
      <Navbar/>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/edit-room/:roomId' element={<EditRoom/>}/>
        <Route path='/all-rooms' element={<ExistingRooms/>}/>
        <Route path='/add' element={<AddRoom/>}/>
        <Route path='/browse-all-rooms' element={<RoomListing/>}/>
        <Route path='/book-room/:roomId' element={<Checkout/>}/>
        <Route path='/admin' element={<Admin/>}/>
        <Route path='/booking-success' element={<BookingSuccess/>}/>
      </Routes>
    </Router>
    <Footer/>
  </main>

  </>
}

export default App