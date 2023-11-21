import Foundation

@objc public class DefaultGateway: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
