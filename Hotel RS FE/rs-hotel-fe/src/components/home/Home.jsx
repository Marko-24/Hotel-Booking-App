import Parallax from "../common/Parallax"
import RoomCarousel from "../common/RoomCarousel"
import HeaderHome from "../layout/HeaderHome"
import HotelServices from "../service/HotelServices"

const Home = () => {
  return (
    <section>
        <HeaderHome/>
        <section className="container">
            <HotelServices/>
            <Parallax/>
            <RoomCarousel/>
        </section>
    </section>
  )
}

export default Home