# Run these commands before starting the server 
#pip install grpcio grpcio-tools
#python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. greeter.proto


import grpc
import greeter_pb2
import greeter_pb2_grpc

def run():
    # Establish insecure HTTP/2 channel to Spring Boot server
    with grpc.insecure_channel('localhost:9090') as channel:
        # Create a stub (client)
        stub = greeter_pb2_grpc.GreeterStub(channel)
        
        # Build the payload message
        request = greeter_pb2.HelloRequest(name='Python Client')
        
        # Call the remote method
        response = stub.SayHello(request)
        
    print("Response received: " + response.message)

if __name__ == '__main__':
    run()
