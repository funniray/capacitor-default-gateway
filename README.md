# capacitor-default-gateway

capacitor polyfill for default-gateway

## Install

```bash
npm install capacitor-default-gateway
npx cap sync
```

## API

<docgen-index>

* [`gateway4async()`](#gateway4async)
* [`gateway6async()`](#gateway6async)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### gateway4async()

```typescript
gateway4async() => Promise<Result<4>>
```

**Returns:** <code>Promise&lt;<a href="#result">Result</a>&lt;4&gt;&gt;</code>

--------------------


### gateway6async()

```typescript
gateway6async() => Promise<Result<6>>
```

**Returns:** <code>Promise&lt;<a href="#result">Result</a>&lt;6&gt;&gt;</code>

--------------------


### Interfaces


#### Result

| Prop          | Type                        | Description                                                                                                         |
| ------------- | --------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| **`gateway`** | <code>string</code>         | The IP address of the default gateway.                                                                              |
| **`version`** | <code>Family</code>         | The IP address version of `gateway`.                                                                                |
| **`int`**     | <code>string \| null</code> | Name of the interface. On Windows, this is the network adapter name. This can be `null` if it cannot be determined. |

</docgen-api>
