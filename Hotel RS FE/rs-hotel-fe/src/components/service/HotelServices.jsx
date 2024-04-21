import { Container, Row, Col, Card } from 'react-bootstrap';
import Header from '../common/Header';
import { FaClock, FaCocktail, FaParking, FaSnowflake, FaUtensils, FaWifi } from 'react-icons/fa';
import { FaShirt } from 'react-icons/fa6';

const HotelServices = () => {
  return (
    <>
        <Container className='mb-2'>
            <Header title={"What we offer"}/>
            <br/>
            <Row>
                <h4 className='text-center'>
                    Services at <span className='hotel-color'>Hotel RS </span>
                    <hr/>
                    <span className='gap-2'>
                        <FaClock/> 24-Hour Reception 
                    </span>
                </h4>
            </Row>
            <Row xs={1} md={2} lg={3} className='g-4 mt-2'>
                <Col>
                    <Card>
                        <Card.Body>
                            <Card.Title className='hotel-color'>
                                <FaParking/> Parking
                            </Card.Title>
                            <Card.Text>A special place for your car at our on-site parking.</Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
                <Col>
                    <Card>
                        <Card.Body>
                            <Card.Title className='hotel-color'>
                                <FaWifi/> Wifi
                            </Card.Title>
                            <Card.Text>Stay connected with high-speed internet access.</Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
                <Col>
                    <Card>
                        <Card.Body>
                            <Card.Title className='hotel-color'>
                                <FaSnowflake/> Air Conditioning
                            </Card.Title>
                            <Card.Text>Always keep a comfortable temperature.</Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
                <Col>
                    <Card>
                        <Card.Body>
                            <Card.Title className='hotel-color'>
                                <FaUtensils/> Breakfast
                            </Card.Title>
                            <Card.Text>Start your day with our breakfast buffet.</Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
                <Col>
                    <Card>
                        <Card.Body>
                            <Card.Title className='hotel-color'>
                                <FaCocktail/> Minibar
                            </Card.Title>
                            <Card.Text>Enjoy a refreshing beverage/snack at all times.</Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
                <Col>
                    <Card>
                        <Card.Body>
                            <Card.Title className='hotel-color'>
                                <FaShirt/> Laundry
                            </Card.Title>
                            <Card.Text>Always have clean clothes on you.</Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    </>
  )
}

export default HotelServices